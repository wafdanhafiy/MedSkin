package com.protel.medskin.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.protel.medskin.data.SkinScanRepository
import com.protel.medskin.di.Injection
import com.protel.medskin.ui.analytics.AnalyticsViewModel
import com.protel.medskin.ui.article.ArticlesViewModel
import com.protel.medskin.ui.nearby.NearByViewModel

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