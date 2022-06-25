package com.protel.medskin.ui.detail

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.protel.medskin.R
import com.protel.medskin.data.skinsEntity
import com.protel.medskin.databinding.ActivityDetailResultBinding
import com.protel.medskin.ml.SkinModel
import com.protel.medskin.ui.nearby.NearByActivity
import com.protel.medskin.ui.nearby.NearByNotActivity
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.task.vision.detector.ObjectDetector


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
        }else{
            scans(apa)
        }

        if (ppp != null) {
            scans(ppp)
        }
    }

    private fun scans(bitmap: Bitmap) {
        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]
        val model = SkinModel.newInstance(this)

        val image = TensorImage.fromBitmap(bitmap)

        val outputs = model.process(image)
        val probability = outputs.probabilityAsCategoryList
        val hasil = probability.maxByOrNull { it.score }?.label ?: "NO_SKINS"

        viewModel.setSelectedskin(hasil)
        viewModel.getSkin()?.let { populateskins(it)}

        val textWithResult = probability.maxByOrNull{ it.score }?.score
        if (textWithResult != null) {
            binding.akurasi.text = "${textWithResult*100}%"
        }

        model.close()
    }

    private fun scan(bitmap: Bitmap) {
        val image = TensorImage.fromBitmap(bitmap)

        val options = ObjectDetector.ObjectDetectorOptions.builder()
            .setMaxResults(5)
            .setScoreThreshold(0.3f)
            .build()
        val detector = ObjectDetector.createFromFileAndOptions(
            this,
            "SkinModel.tflite",
            options
        )
        val results = detector.detect(image)

        val resultToDisplay = results.map {
            val category = it.categories.first()
            val text = "${category.label}, ${category.score.times(100).toInt()}%"
            //DetectionResult(it.boundingBox, text)
        }
        val textWithResult = resultToDisplay.toString()
        //val imgWithResult = image
        runOnUiThread {
            binding.akurasi.text = textWithResult
            //binding.gambarinfo.setImageBitmap(imgWithResult)
        }
    }


    private fun populateskins(skinsEntity: skinsEntity) {
        with(binding) {
            judul.text = skinsEntity.name
            penyebab.text = skinsEntity.penyebab
            gejala.text = skinsEntity.gejala
            penanggulangan.text = skinsEntity.penanggulangan
        }
        Glide.with(this)
            .load(skinsEntity.gambar)
            .apply(RequestOptions().override(3500, 2000))
            .centerCrop()
            .into(binding.gambarinfo)

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

