package com.protel.medskin.ui.analytics

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
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
import com.protel.medskin.BuildConfig
import com.protel.medskin.databinding.FragmentAnalitycsBinding
import com.protel.medskin.ui.detail.DetailResultActivity
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


private const val FILE_NAME = "photo.jpg"
private const val REQUEST_CODE = 42
private const val GALLERY_REQUEST_CODE = 2
private lateinit var photoFile : File
private lateinit var galleryphotoFile : File
private lateinit var FilePhoto : String
private lateinit var currentPhotoPath : String
lateinit var bitmap: Bitmap


class AnalyticsFragment : Fragment() {
    //ImageView mImageview
    //var imagePicker: ImageView? = null
    //private var resolver: ContentResolver? = requireActivity().contentResolver
    lateinit var imageView: ImageView
    private lateinit var scanViewModel: AnalyticsViewModel
    private var _binding: FragmentAnalitycsBinding? = null
    private var fileUri: Uri? = null
    private var mImageFileLocation = ""
    private val binding get() = _binding!!

    companion object {
        const val SHOWCASE_ID = "SHOWCASE_ID_1"
        const val REQUEST_TAKE_PHOTO = 0
        const val REQUEST_PICK_PHOTO = 2
        const val CAMERA_PIC_REQUEST = 1111

        private val TAG = AnalyticsFragment::class.java.simpleName

        const val MEDIA_TYPE_IMAGE = 1
        private const val IMAGE_DIRECTORY_NAME = "Android File Upload"

        private fun getOutputMediaFile(type: Int): File? {

            val mediaStorageDir = File(
                Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                IMAGE_DIRECTORY_NAME
            )
            if (!mediaStorageDir.exists()) {
                if (!mediaStorageDir.mkdirs()) {
                    Log.d(
                        TAG, "Oops! Failed create "
                                + IMAGE_DIRECTORY_NAME + " directory"
                    )
                    return null
                }
            }

            SimpleDateFormat(
                "yyyyMMdd_HHmmss",
                Locale.getDefault()
            ).format(Date())
            val mediaFile: File
            if (type == MEDIA_TYPE_IMAGE) {
                mediaFile = File(
                    mediaStorageDir.path + File.separator
                            + "IMG_" + ".jpg"
                )
            } else {
                return null
            }

            return mediaFile
        }
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

            //Create an Intent with action as ACTION_PICK
            //Create an Intent with action as ACTION_PICK
            val intent = Intent(Intent.ACTION_PICK)
            // Sets the type as image/*. This ensures only components of type image are selected
            // Sets the type as image/*. This ensures only components of type image are selected
            intent.type = "image/*"
            //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.
            //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.
            val mimeTypes = arrayOf("image/jpeg", "image/png")
            intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
            // Launching the Intent
            // Launching the Intent
            startActivityForResult(intent, GALLERY_REQUEST_CODE)
        }

        binding.camBtn.setOnClickListener {
            if (Build.VERSION.SDK_INT > 21) {
                val callCameraApplicationIntent = Intent()
                callCameraApplicationIntent.action = MediaStore.ACTION_IMAGE_CAPTURE

                var photoFile: File? = null

                try {
                    photoFile = createImageFile()
                } catch (e: IOException) {

                    e.printStackTrace()
                }
                val outputUri = FileProvider.getUriForFile(
                    requireActivity(),
                    BuildConfig.APPLICATION_ID + ".provider",
                    photoFile!!
                )
                callCameraApplicationIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri)

                callCameraApplicationIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION)

                startActivityForResult(callCameraApplicationIntent, CAMERA_PIC_REQUEST)
            } else {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE)

                intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri)

                startActivityForResult(intent, CAMERA_PIC_REQUEST)
            }

        }

        return root
    }
    private fun getOutputMediaFileUri(type: Int): Uri {
        return Uri.fromFile(getOutputMediaFile(type))
    }

    private fun getPhotoFile(fileName: String): File {
        val storageDirectory = context?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(fileName, ".jpg", storageDirectory)
    }

    @Throws(IOException::class)
    internal fun createImageFile(): File {

        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmSS").format(Date())
        val imageFileName = "IMAGE_" + timeStamp
        val storageDirectory =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES + "/photo_saving_app")

        if (!storageDirectory.exists()) storageDirectory.mkdir()
        val image = File(storageDirectory, "$imageFileName.jpg")

        mImageFileLocation = image.absolutePath
        return image
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

//                    val galleryimage = BitmapFactory.decodeFile(galleryphotoFile.absolutePath)
//                    binding.imagecam.setImageBitmap(galleryimage)

//                    val returnUri: Uri? = data?.data
//                    val contentResolver = requireActivity().contentResolver
//                    val bitmapImage = MediaStore.Images.Media.getBitmap(contentResolver, returnUri)
                    //bitmapImage.scale(1,1)

//                    binding.imagecam.setImageBitmap(galleryimage)
                    //val takenImageGal = BitmapFactory.decodeFile(galleryphotoFile.absolutePath)
                    //binding.imagecam.setImageBitmap(takenImageGal)


                    //btngallery()

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