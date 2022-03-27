package com.bangkit.medskin.di

import android.content.Context
import com.bangkit.medskin.data.SkinScanRepository
import com.bangkit.medskin.data.source.remote.RemoteDataSource
import com.bangkit.medskin.utils.JsonHelper

object Injection {
    fun provideSkinScanRepository(context: Context): SkinScanRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        return SkinScanRepository.getInstance(remoteDataSource)
    }
}