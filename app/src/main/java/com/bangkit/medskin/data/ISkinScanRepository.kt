package com.bangkit.medskin.data

import androidx.lifecycle.LiveData
import com.bangkit.medskin.data.source.local.entity.ArticleEntity
import com.bangkit.medskin.data.source.local.entity.MapsEntity
import com.bangkit.medskin.data.source.local.entity.PredictionEntity
import okhttp3.RequestBody


interface ISkinScanRepository {
    fun getAllArticles(): LiveData<List<ArticleEntity>>
    fun getHospitalNearBy(latitude: String, longitude: String): LiveData<List<MapsEntity>>
    fun getPrediction(hashMap: HashMap<String, RequestBody>): LiveData<PredictionEntity>
}