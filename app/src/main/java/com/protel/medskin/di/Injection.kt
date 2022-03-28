package com.protel.medskin.di

import android.content.Context
import com.protel.medskin.data.SkinScanRepository
import com.protel.medskin.data.source.remote.RemoteDataSource
import com.protel.medskin.utils.JsonHelper

object Injection {
    fun provideSkinScanRepository(context: Context): SkinScanRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        return SkinScanRepository.getInstance(remoteDataSource)
    }
}