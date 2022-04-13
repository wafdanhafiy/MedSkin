package com.protel.medskin.utils

import com.protel.medskin.data.PlantsEntity

object dataDummy {

    fun generateDummyPlants(): List<PlantsEntity>{
        val plants = ArrayList<PlantsEntity>()
        plants.add(PlantsEntity("Acne",
        ))

        return plants
    }

}