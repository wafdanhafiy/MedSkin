package com.protel.medskin.utils

import com.protel.medskin.data.skinsEntity

object dataDummy {

    fun generateDummySkins(): List<skinsEntity>{
        val plants = ArrayList<skinsEntity>()
        plants.add(skinsEntity("Acne",
            "Disebabkan oleh bakteri pada pori-pori kulit",
            "Gejala jerawat yaitu kulit berwarna merah dikarenakan bernanah, sensasi panas dikarenakan peradangan, dan rasa gatal",
            "Rajin menjaga kebersihan diri khususnya bagian muka.",
            "Anda disarankan untuk konsultasi ke dokter untuk menghindari potensi kanker yang berbahaya",
            "berbahaya",
            "Tidak Bahaya"
        ))

        return plants
    }

}