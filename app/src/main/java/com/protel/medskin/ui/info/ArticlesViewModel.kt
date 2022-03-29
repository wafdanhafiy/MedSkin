package com.protel.medskin.ui.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.protel.medskin.data.MedSkinRepository
import com.protel.medskin.data.source.local.entity.ArticleEntity

class ArticlesViewModel(private val MedSkinRepository: MedSkinRepository) : ViewModel() {


    fun resultArticle(): LiveData<List<ArticleEntity>> = MedSkinRepository.getAllArticles()

}