package com.protel.medskin.ui.analytics

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.protel.medskin.databinding.FragmentAnalitycsBinding
import com.protel.medskin.ui.detail.DetailResultActivity
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


private const val REQUEST_CODE = 0
private const val GALLERY_REQUEST_CODE = 2
private lateinit var photoFile : File
private lateinit var currentPhotoPath : String
lateinit var bitmap: Bitmap
private const val FILE_NAME = "IMG_"

class AnalyticsFragment : Fragment() {
    lateinit var imageView: ImageView
    private lateinit var scanViewModel: AnalyticsViewModel
    private var _binding: FragmentAnalitycsBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val SHOWCASE_ID = "SHOWCASE_ID_1"

        private val TAG = AnalyticsFragment::class.java.simpleName

        const val MEDIA_TYPE_IMAGE = 1
        private const val IMAGE_DIRECTORY_NAME = "Android File Upload"

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showCaseAnalytics()
    }

    private fun showCaseAnalytics() {
        val config = ShowcaseConfig()
        config.delay = 100
        val sequence = MaterialShowcaseSequence(activity, SHOWCASE_ID)

        sequence.setConfig(config)

        sequence.addSequenceItem(
            binding.takeImageShowCase,
            "Tekan 'Ambil Gambar' untuk mengaktifkan kamera dan mengambil foto", "Oke, lanjut"
        )

        sequence.addSequenceItem(
            binding.choseImageShowCase,
            "Tekan 'Pilih Gambar' untuk mengambil gambar dari penyimpanan lokal", "Oke, lanjut"
        )


        sequence.addSequenceItem(
            binding.processShowCase,
            "Tekan 'Oke' untuk menjalankan prediagnosa", "Mengerti"
        )

        sequence.start()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        scanViewModel =
            ViewModelProvider(this).get(AnalyticsViewModel::class.java)

        _binding = FragmentAnalitycsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.uploadBtn.setOnClickListener {

            val intent = Intent(Intent.ACTION_PICK)

            intent.type = "image/*"

            val mimeTypes = arrayOf("image/jpeg", "image/png")
            intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)

            startActivityForResult(intent, GALLERY_REQUEST_CODE)
        }

        binding.camBtn.setOnClickListener {
            captureImage()
        }

        return root
    }

    private fun captureImage(){
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        photoFile = getPhotoFileUri(FILE_NAME)

        val fileProvider = context?.let { it1 ->
            FileProvider.getUriForFile(
                it1, "com.protel.medskin.provider",
                photoFile
            )
        }
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider)
        if (context?.let { it1 -> takePictureIntent.resolveActivity(it1.packageManager) } != null) {
            startActivityForResult(takePictureIntent, REQUEST_CODE)
        } else {
            Toast.makeText(context, "unable to open camera", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getPath(context: Context, uri: Uri?): String? {
        var result: String? = null
        val proj = arrayOf(MediaStore.Images.Media._ID)
        val cursor: Cursor? =
            uri?.let { context.contentResolver.query(it, proj, null, null, null) }
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                val column_index: Int = cursor.getColumnIndexOrThrow(proj[0])
                result = cursor.getString(column_index)
            }
            cursor.close()
        }
        if (result == null) {
            result = "Not found"
        }
        return result
    }

    fun getPhotoFileUri(imageFileName: String): File {
        val storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(imageFileName, ".jpg", storageDir)
//        val mediaStorageDir =
//            File(context?.getExternalFilesDir(Environment.DIRECTORY_PICTURES), APP_TAG)
//        val mediaStorageDir =
//            File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), APP_TAG)
//
//        if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()) {
//            Log.d(APP_TAG, "failed to create directory")
//        }
//
//        return File(mediaStorageDir.path + File.separator + fileName)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK)

            when (requestCode) {

                REQUEST_CODE -> {
                    val takenImage = BitmapFactory.decodeFile(photoFile.absolutePath)
                    binding.imageAnalitics.setImageBitmap(takenImage)

                    binding.buttonProcess.setOnClickListener {
                        val nextIntent = Intent(context, DetailResultActivity::class.java)
                        nextIntent.putExtra("picture", photoFile.absolutePath)
                        Log.e(photoFile.absolutePath, photoFile.absolutePath)
                        startActivity(nextIntent)
                    }

                }

                GALLERY_REQUEST_CODE -> {

                    val selectedImage: Uri = data?.data ?: return
                    val mBitmap: Bitmap = MediaStore.Images.Media.getBitmap(context?.contentResolver, selectedImage)
                    binding.imageAnalitics.setImageBitmap(mBitmap)

                    val picturePath = context?.let { getPath(it, selectedImage) }

                    binding.buttonProcess.setOnClickListener {
                        val nextIntentGallery = Intent(context, DetailResultActivity::class.java)
                        nextIntentGallery.putExtra("picturegal", selectedImage)
                        nextIntentGallery.putExtra("imageUri", selectedImage)
                        if (picturePath != null) {
                            Log.e(picturePath,picturePath)
                        }
                        startActivity(nextIntentGallery)
                    }
                }

            }
    }
}