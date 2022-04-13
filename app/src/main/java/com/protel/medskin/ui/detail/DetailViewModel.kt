package com.protel.medskin.ui.detail

import androidx.lifecycle.ViewModel
import com.protel.medskin.data.PlantsEntity
import com.protel.medskin.utils.dataDummy

class DetailViewModel: ViewModel() {
    private lateinit var plantsId: String
    private lateinit var plantsId2: String
    private lateinit var plantsId3: String

    fun setSelectedplant(plantsId: String){
        this.plantsId = plantsId
    }

    fun getPlant(): PlantsEntity? {
        var plant: PlantsEntity? =null
        val plantsEntity = dataDummy.generateDummyPlants()
        for (plantsEntity in plantsEntity) {
            if (plantsEntity.name == plantsId) {
                plant = plantsEntity
            }
//            else {
//                val intent = Intent(Intent.ACTION_WEB_SEARCH)
//                intent.putExtra(SearchManager.QUERY, plantsId)
//                startActivity(intent)
//            }
        }
        return plant

    }

}