package com.protel.medskin.ui.datalist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.protel.medskin.R
import com.protel.medskin.data.source.local.entity.DataEntity
import com.protel.medskin.databinding.ItemRowDataBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions


class DataAdapter : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {
    private val list = ArrayList<DataEntity>()
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: DataEntity)
    }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRowDataBinding.bind(itemView)
        fun bind(data: DataEntity) {
            binding.apply {

                titleData.text = data.title
                Glide.with(itemView)
                    .load(data.imgPath)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(imageView)
            }
            itemView.setOnClickListener { onItemClickCallback.onItemClicked(data) }
        }
    }

    fun setList(data: List<DataEntity>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_data, parent, false)
        return DataViewHolder(mView)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}