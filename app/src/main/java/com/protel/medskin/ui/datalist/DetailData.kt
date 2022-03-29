package com.protel.medskin.ui.datalist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.protel.medskin.R
import com.protel.medskin.data.source.local.entity.DataEntity
import com.protel.medskin.databinding.ActivityDataDetailBinding
import com.bumptech.glide.Glide

class DetailData : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    lateinit var binding: ActivityDataDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataDetailBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)
        title = getString(R.string.title_detail_data)

        val detailData = intent.getParcelableExtra<DataEntity>(EXTRA_DATA)
        populateDataList(detailData)


    }

    private fun populateDataList(data: DataEntity?) {
        data?.let {
            binding.titleData.text = data.title
            binding.tvContent.text = data.description

            Glide.with(this)
                .load(data.imgPath)
                .into(binding.imageView)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
