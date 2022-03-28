package com.protel.medskin.data.source.remote

import android.util.Log
import com.protel.medskin.data.source.remote.network.ApiConfig
import com.protel.medskin.data.source.remote.response.ArticleResponse
import com.protel.medskin.data.source.remote.response.ResponseMaps
import com.protel.medskin.data.source.remote.response.ResultResponse
import com.protel.medskin.data.source.remote.response.ResultsItem
import com.protel.medskin.utils.JsonHelper
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {


    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply {
                    instance = this
                }
            }
    }

    fun getAllArticles(callback: LoadArticleCallback) {
        callback.onAllArticleReceived(jsonHelper.loadArticle())
    }

    interface LoadArticleCallback{
        fun onAllArticleReceived(articleResponse: List<ArticleResponse>)
}


    fun getHospitalNearBy(
        callback: LoadHospitalNearBy,
        latitude: String,
        longitude: String
    ) {
        val location = "$latitude,$longitude"
        ApiConfig.getApiService().getHospitalNearBye(
            location
        )
            .enqueue(object : Callback<ResponseMaps> {
                override fun onResponse(
                    call: Call<ResponseMaps>,
                    response: Response<ResponseMaps>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.results?.let { callback.onMapsHospitalReceived(it) }
                    }
                }

                override fun onFailure(call: Call<ResponseMaps>, t: Throwable) {
                    Log.e("Failure", "${t.message}")
                }
            })
    }

    fun getPrediction(
        callback: LoadPredictionCancer,
        map: HashMap<String, RequestBody>
    ) {
        ApiConfig.getApiServiceImageUploader().getPrediction(map)
            .enqueue(object : Callback<ResultResponse> {
                override fun onResponse(
                    call: Call<ResultResponse>,
                    response: Response<ResultResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { callback.onPredictionReceived(it) }
                    }
                }

                override fun onFailure(call: Call<ResultResponse>, t: Throwable) {
                    Log.e("Failure", "${t.message}")
                }
            })
    }

    interface LoadHospitalNearBy {
        fun onMapsHospitalReceived(hospitalResponse: List<ResultsItem?>)
    }

    interface LoadPredictionCancer {
        fun onPredictionReceived(resultResponse: ResultResponse)
    }


}