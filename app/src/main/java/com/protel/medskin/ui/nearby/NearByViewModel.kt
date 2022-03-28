package com.protel.medskin.ui.nearby

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.protel.medskin.data.SkinScanRepository
import com.protel.medskin.data.source.local.entity.MapsEntity

class NearByViewModel(private val mSkinScanRepository: SkinScanRepository) : ViewModel() {

    fun getHospitalNearBy(latitude: String, longitude: String): LiveData<List<MapsEntity>> =
        mSkinScanRepository.getHospitalNearBy(latitude, longitude)
}