package com.protel.medskin.ui.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.protel.medskin.data.MedSkinRepository
import com.protel.medskin.data.source.local.entity.ArticleEntity

class InfoViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Under Development"
    }
    val text: LiveData<String> = _text
}