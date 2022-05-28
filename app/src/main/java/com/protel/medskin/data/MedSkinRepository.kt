package com.protel.medskin.data

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.protel.medskin.data.source.local.entity.ArticleEntity
import com.protel.medskin.data.source.local.entity.DataEntity
import com.protel.medskin.data.source.local.entity.MapsEntity
import com.protel.medskin.data.source.local.entity.PredictionEntity
import com.protel.medskin.data.source.remote.RemoteDataSource
import com.protel.medskin.data.source.remote.response.ArticleResponse
import com.protel.medskin.data.source.remote.response.DataResponse
import com.protel.medskin.data.source.remote.response.ResultResponse
import com.protel.medskin.data.source.remote.response.ResultsItem
import okhttp3.RequestBody

class MedSkinRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    IMedSkinRepository {
    companion object {
        @Volatile
        private var instance: MedSkinRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): MedSkinRepository =
            instance ?: synchronized(this) {
                instance ?: MedSkinRepository(remoteDataSource).apply {
                    instance = this
                }
            }
    }

    override fun getAllArticles(): LiveData<List<ArticleEntity>>{
        val articleResult = MutableLiveData<List<ArticleEntity>>()
        remoteDataSource.getAllArticles(object : RemoteDataSource.LoadArticleCallback {
            override fun onAllArticleReceived(articleResponse: List<ArticleResponse>) {
                val articleList = ArrayList<ArticleEntity>()
                for (response in articleResponse) {
                    val article = ArticleEntity(response.id,
                        response.author,
                        response.title,
                        response.description,
                        response.release_date,
                        response.imgPath)

                    articleList.add(article)
                }
                articleResult.postValue(articleList)
            }
        })


        return articleResult
    }

    override fun getAllData(): LiveData<List<DataEntity>>{
        val dataResult = MutableLiveData<List<DataEntity>>()
        remoteDataSource.getAllData(object : RemoteDataSource.LoadDataCallback {
            override fun onAllDataReceived(dataResponse: List<DataResponse>) {
                val dataList = ArrayList<DataEntity>()
                for (response in dataResponse) {
                    val data = DataEntity(response.id,
                        response.title,
                        response.penyebab,
                        response.gejala,
                        response.cara,
                        response.imgPath)

                    dataList.add(data)
                }
                dataResult.postValue(dataList)
            }
        })


        return dataResult
    }

    override fun getHospitalNearBy(
        latitude: String,
        longitude: String
    ): LiveData<List<MapsEntity>> {
        val hospitalResult = MutableLiveData<List<MapsEntity>>()
        remoteDataSource.getHospitalNearBy(
            latitude = latitude, longitude = longitude,
            callback = object : RemoteDataSource.LoadHospitalNearBy {

                override fun onMapsHospitalReceived(hospitalResponse: List<ResultsItem?>) {
                    val tvShowList = ArrayList<MapsEntity>()
                    for (response in hospitalResponse) {
                        if (response != null) {
                            val hospital = response.geometry?.location?.let {
                                MapsEntity(
                                    namePlace = response.name.toString(),
                                    latitude = it.lat,
                                    lng = it.lng,
                                    nameStreet = response.vicinity.toString(),
                                    id = "1"
                                )
                            }
                            if (hospital != null) {
                                tvShowList.add(hospital)
                            }
                        }
                    }
                    hospitalResult.postValue(tvShowList)
                }
            })

        return hospitalResult
    }

    override fun getPrediction(hashMap: HashMap<String, RequestBody>): LiveData<PredictionEntity> {
        val predictionResult = MutableLiveData<PredictionEntity>()
        remoteDataSource.getPrediction(
            map = hashMap,
            callback = object : RemoteDataSource.LoadPredictionCancer {
                @SuppressLint("NullSafeMutableLiveData")
                override fun onPredictionReceived(resultResponse: ResultResponse) {
                    val responseResultPrediction= resultResponse.predictionResult?.let {
                        PredictionEntity(
                            prediction = it
                        )
                    }
                    if (responseResultPrediction != null) {
                        predictionResult.postValue(responseResultPrediction)
                    }
                }
            })

        return predictionResult
    }
}