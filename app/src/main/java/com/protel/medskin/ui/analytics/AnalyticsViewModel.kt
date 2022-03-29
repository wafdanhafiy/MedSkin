package com.protel.medskin.ui.analytics

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.protel.medskin.data.MedSkinRepository
import com.protel.medskin.data.source.local.entity.PredictionEntity
import okhttp3.RequestBody

class AnalyticsViewModel(private val mMedSkinRepository: MedSkinRepository) : ViewModel() {

    fun getPrediction(hashMap: HashMap<String, RequestBody>): LiveData<PredictionEntity> =
        mMedSkinRepository.getPrediction(hashMap)
}