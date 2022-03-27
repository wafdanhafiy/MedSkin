package com.bangkit.medskin.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bangkit.medskin.data.SkinScanRepository
import com.bangkit.medskin.di.Injection
import com.bangkit.medskin.ui.analytics.AnalyticsViewModel
import com.bangkit.medskin.ui.article.ArticlesViewModel
import com.bangkit.medskin.ui.nearby.NearByViewModel

class ViewModelFactory private constructor(private val mSkinScanRepository: SkinScanRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideSkinScanRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(NearByViewModel::class.java) -> {
                NearByViewModel(mSkinScanRepository) as T
            }
            modelClass.isAssignableFrom(AnalyticsViewModel::class.java) -> {
                AnalyticsViewModel(mSkinScanRepository) as T
            }
            modelClass.isAssignableFrom(ArticlesViewModel::class.java) -> {
                return ArticlesViewModel(mSkinScanRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}