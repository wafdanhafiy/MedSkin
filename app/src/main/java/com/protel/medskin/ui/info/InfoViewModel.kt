package com.protel.medskin.ui.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.protel.medskin.data.MedSkinRepository
import com.protel.medskin.data.source.local.entity.ArticleEntity

class InfoViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Medskin merupakan aplikasi telemedicine untuk melakukan prediagnosa penyakit kulit yang Anda derita dan memberikan informasi mengenai penyakit kulit yang Anda derita seperti penyebab, gejala, dan cara penanganan. Serta menunjukkan lokasi dermantologis terdekat di sekitar lokasi Anda."
    }
    val text: LiveData<String> = _text
}