package com.protel.medskin.di

import android.content.Context
import com.protel.medskin.data.MedSkinRepository
import com.protel.medskin.data.source.remote.RemoteDataSource
import com.protel.medskin.utils.JsonHelper

object Injection {
    fun provideMedSkinRepository(context: Context): MedSkinRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        return MedSkinRepository.getInstance(remoteDataSource)
    }
}