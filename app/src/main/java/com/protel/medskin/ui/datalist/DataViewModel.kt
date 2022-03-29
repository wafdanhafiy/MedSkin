package com.protel.medskin.ui.datalist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.protel.medskin.data.MedSkinRepository
import com.protel.medskin.data.source.local.entity.DataEntity

class DataViewModel(private val MedSkinRepository: MedSkinRepository) : ViewModel() {


    fun resultData(): LiveData<List<DataEntity>> = MedSkinRepository.getAllData()

}