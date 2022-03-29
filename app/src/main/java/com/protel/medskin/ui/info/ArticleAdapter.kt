package com.protel.medskin.ui.info

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.protel.medskin.R
import com.protel.medskin.data.source.local.entity.ArticleEntity
import com.protel.medskin.databinding.ItemRowArticlesBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions


class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    private val list = ArrayList<ArticleEntity>()
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ArticleEntity)
    }

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRowArticlesBinding.bind(itemView)
        fun bind(article: ArticleEntity) {
            binding.apply {

                titleArticle.text = article.title
                subArtcile.text = article.description
                timeArticle.text = article.release_date
                Glide.with(itemView)
                    .load(article.imgPath)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(imageView)
            }
            itemView.setOnClickListener { onItemClickCallback.onItemClicked(article) }
        }
    }

    fun setList(article: List<ArticleEntity>) {
        list.clear()
        list.addAll(article)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_articles, parent, false)
        return ArticleViewHolder(mView)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}