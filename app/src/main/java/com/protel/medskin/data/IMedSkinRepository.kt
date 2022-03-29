package com.protel.medskin.data

import androidx.lifecycle.LiveData
import com.protel.medskin.data.source.local.entity.ArticleEntity
import com.protel.medskin.data.source.local.entity.DataEntity
import com.protel.medskin.data.source.local.entity.MapsEntity
import com.protel.medskin.data.source.local.entity.PredictionEntity
import okhttp3.RequestBody


interface IMedSkinRepository {
    fun getAllArticles(): LiveData<List<ArticleEntity>>
    fun getAllData(): LiveData<List<DataEntity>>
    fun getHospitalNearBy(latitude: String, longitude: String): LiveData<List<MapsEntity>>
    fun getPrediction(hashMap: HashMap<String, RequestBody>): LiveData<PredictionEntity>
}