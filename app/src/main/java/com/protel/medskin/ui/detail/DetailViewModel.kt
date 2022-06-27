package com.protel.medskin.ui.detail

import androidx.lifecycle.ViewModel
import com.protel.medskin.data.skinsEntity
import com.protel.medskin.utils.dataDummy

class DetailViewModel: ViewModel() {
    private lateinit var skinsId: String

    fun setSelectedskin(skinsId: String){
        this.skinsId = skinsId
    }

    fun getSkin(): skinsEntity? {
        var skin: skinsEntity? =null
        val skinsEntity = dataDummy.generateDummySkins()
        for (skinsEntity in skinsEntity) {
            if (skinsEntity.name == skinsId) {
                skin = skinsEntity
            }
        }
        return skin
    }
}