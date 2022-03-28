package com.protel.medskin.ui.analytics

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.protel.medskin.data.SkinScanRepository
import com.protel.medskin.data.source.local.entity.PredictionEntity
import okhttp3.RequestBody

class AnalyticsViewModel(private val mSkinScanRepository: SkinScanRepository) : ViewModel() {

    fun getPrediction(hashMap: HashMap<String, RequestBody>): LiveData<PredictionEntity> =
        mSkinScanRepository.getPrediction(hashMap)
}