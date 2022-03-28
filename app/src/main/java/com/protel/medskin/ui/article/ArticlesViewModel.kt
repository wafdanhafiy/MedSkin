package com.protel.medskin.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.protel.medskin.data.SkinScanRepository
import com.protel.medskin.data.source.local.entity.ArticleEntity

class ArticlesViewModel(private val skinScanRepository: SkinScanRepository) : ViewModel() {


    fun resultArticle(): LiveData<List<ArticleEntity>> = skinScanRepository.getAllArticles()

}