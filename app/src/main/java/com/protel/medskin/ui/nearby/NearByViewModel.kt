package com.protel.medskin.ui.nearby

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.protel.medskin.data.MedSkinRepository
import com.protel.medskin.data.source.local.entity.MapsEntity

class NearByViewModel(private val mMedSkinRepository: MedSkinRepository) : ViewModel() {

    fun getHospitalNearBy(latitude: String, longitude: String): LiveData<List<MapsEntity>> =
        mMedSkinRepository.getHospitalNearBy(latitude, longitude)
}