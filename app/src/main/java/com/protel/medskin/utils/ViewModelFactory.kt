package com.protel.medskin.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.protel.medskin.data.MedSkinRepository
import com.protel.medskin.di.Injection
import com.protel.medskin.ui.analytics.AnalyticsViewModel
import com.protel.medskin.ui.article.ArticlesViewModel
import com.protel.medskin.ui.datalist.DataViewModel
import com.protel.medskin.ui.nearby.NearByViewModel

class ViewModelFactory private constructor(private val mMedSkinRepository: MedSkinRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideMedSkinRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(NearByViewModel::class.java) -> {
                NearByViewModel(mMedSkinRepository) as T
            }
            modelClass.isAssignableFrom(ArticlesViewModel::class.java) -> {
                return ArticlesViewModel(mMedSkinRepository) as T
            }
            modelClass.isAssignableFrom(DataViewModel::class.java) -> {
                return DataViewModel(mMedSkinRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}