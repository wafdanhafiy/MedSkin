package com.protel.medskin.utils

import com.protel.medskin.data.skinsEntity

object dataDummy {

    fun generateDummySkins(): List<skinsEntity>{
        val skins = ArrayList<skinsEntity>()
        skins.add(skinsEntity(
            "AIDS",
            "penyebab_placeholder",
            "gejala_placeholder",
            "penanggulangan_placeholder"
        ))

        skins.add(skinsEntity(
            "Acne",
            "Disebabkan oleh bakteri pada pori-pori kulit",
            "Gejala jerawat yaitu kulit berwarna merah dikarenakan bernanah, sensasi panas dikarenakan peradangan, dan rasa gatal",
            "Rajin menjaga kebersihan diri khususnya bagian muka."
        ))

        return skins
    }

}