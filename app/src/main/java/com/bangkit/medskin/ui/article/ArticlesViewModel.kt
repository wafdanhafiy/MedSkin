package com.bangkit.medskin.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bangkit.medskin.data.SkinScanRepository
import com.bangkit.medskin.data.source.local.entity.ArticleEntity

class ArticlesViewModel(private val skinScanRepository: SkinScanRepository) : ViewModel() {


    fun resultArticle(): LiveData<List<ArticleEntity>> = skinScanRepository.getAllArticles()

}