package com.protel.medskin.ui.analytics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.protel.medskin.data.MedSkinRepository
import com.protel.medskin.data.source.local.entity.PredictionEntity
import okhttp3.RequestBody

class AnalyticsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is scan Fragment"
    }
    val text: LiveData<String> = _text
}