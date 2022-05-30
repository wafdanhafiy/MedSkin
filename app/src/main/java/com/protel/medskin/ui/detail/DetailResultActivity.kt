package com.protel.medskin.ui.detail

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.protel.medskin.R
import com.protel.medskin.data.skinsEntity
import com.protel.medskin.databinding.ActivityDetailResultBinding
import com.protel.medskin.ml.SkinModel
import com.protel.medskin.ui.nearby.NearByActivity
import com.protel.medskin.ui.nearby.NearByNotActivity
import org.tensorflow.lite.support.image.TensorImage


class DetailResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailResultBinding

    companion object {
        const val RESULT_PREDICTION = "result_prediction"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailResultBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)
        title = getString(R.string.title_detail)

        BottomSheetBehavior.from(binding.infoframe).apply {
            peekHeight = 200
            this.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        val picture = intent.getStringExtra("picture")
        val pictureGal = intent.getStringExtra("picturegal")

        val uri: Uri? = intent.getParcelableExtra("imageUri")

        // just display image in imageview
        //imageView.setImageBitmap(BitmapFactory.decodeStream(ims))

        val apa = BitmapFactory.decodeFile(picture)
        val gapa = BitmapFactory.decodeFile(pictureGal)
        val ims = uri?.let { contentResolver.openInputStream(it) }
        val ppp = BitmapFactory.decodeStream(ims)

        if (apa == apa) {
            binding.gambarinfo.setImageBitmap(apa)
        }
        if (ppp == ppp) {
            binding.gambarinfo.setImageBitmap(ppp)
        }

        if (apa == null) {
            scans(ppp)
        }

        if (ppp != null) {
            search()
            //binding.searchbtn.text = ""
            scans(ppp)
        }
    }

    private fun scans(bitmap: Bitmap) {
        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]
        val model = SkinModel.newInstance(this)

// Creates inputs for reference.
        val image = TensorImage.fromBitmap(bitmap)

// Runs model inference and gets result.
        val outputs = model.process(image)
        val probability = outputs.probabilityAsCategoryList
        val hasil = probability.maxByOrNull { it.score }?.label ?: "NO_SKINS"

        viewModel.setSelectedskin(hasil)
        viewModel.getSkin()?.let { populateskins(it) }

// Releases model resources if no longer used.
        model.close()
    }

    private fun search() {
//        binding.tombolsearch.setOnClickListener {
//
//         val nextintent = Intent(this, NearByActivity::class.java)
//          startActivity(nextintent)
//
////            binding.gambarinfo.visibility = View.GONE
////            binding.searchbtn.visibility = View.GONE
////            binding.infoframe.visibility = View.GONE
//        }
    }

    private fun notsearch() {
//        binding.tombolsearch.setOnClickListener {
//
//            val nextintent = Intent(this, NearByNotActivity::class.java)
//            startActivity(nextintent)
//
//            binding.gambarinfo.visibility = View.GONE
//            binding.searchbtn.visibility = View.GONE
//            binding.infoframe.visibility = View.GONE
//            binding.tombolcari.visibility=View.GONE
//        }
    }

    private fun populateskins(skinsEntity: skinsEntity) {
        with(binding) {
            judul.text = skinsEntity.name
            penyebab.text = skinsEntity.penyebab
            gejala.text = skinsEntity.gejala
            penanggulangan.text = skinsEntity.penanggulangan
            akurasi.text = skinsEntity.akurasi.toString()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun cobamaps(view: View) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.id/maps/search/Dermatologist/@location"))
        startActivity(browserIntent)
    }

    fun cobabrowser(view: View) {
        with(binding){
            val BASE_URL = "https://www.google.com/search?q="
            val path = judul.text

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(BASE_URL + path))
            startActivity(browserIntent)
        }
    }
}