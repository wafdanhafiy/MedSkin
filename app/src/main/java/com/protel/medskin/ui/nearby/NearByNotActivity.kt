package com.protel.medskin.ui.nearby

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.protel.medskin.R
import com.protel.medskin.data.skinsEntity
import com.protel.medskin.data.source.local.entity.MapsEntity
import com.protel.medskin.databinding.ActivityDetailNearbyBinding
import com.protel.medskin.ml.SkinModel
import com.protel.medskin.ui.detail.DetailViewModel
import com.protel.medskin.utils.ViewModelFactory
import org.tensorflow.lite.support.image.TensorImage

class NearByNotActivity : AppCompatActivity(), LocationListener {
    private lateinit var binding: ActivityDetailNearbyBinding
    var mGoogleMap: GoogleMap? = null
    private lateinit var nearByViewModel: NearByViewModel

    companion object {
        const val RESULT_PREDICTION = "result_prediction"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNearbyBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)
        title = getString(R.string.result)
        val uri: Uri? = intent.getParcelableExtra("imageUri")
        val ims = uri?.let { contentResolver.openInputStream(it) }
        val picture = intent.getStringExtra("picture")
        val ppp = BitmapFactory.decodeStream(ims)
        val apa = BitmapFactory.decodeFile(picture)

        if (ppp != null) {
            //binding.searchbtn.text = ""
            data(ppp)
        }

        val fragment =
            supportFragmentManager.findFragmentById(R.id.fmap) as SupportMapFragment
        fragment.getMapAsync { googleMap ->
            mGoogleMap = googleMap
            initMap()
        }


    }
    private fun dataskins(skinsEntity: skinsEntity) {
        with(binding) {
            resultSub.text=skinsEntity.tidakbahaya
            note.text=skinsEntity.note
        }
    }
    private fun data(bitmap: Bitmap) {
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
        viewModel.getSkin()?.let { dataskins(it) }
    }

    private fun initMap() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                115
            )
            return
        }
        if (mGoogleMap != null) {

            mGoogleMap!!.isMyLocationEnabled = true
            val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
            val criteria = Criteria()
            val provider = locationManager.getBestProvider(criteria, true)
            val location = locationManager.getLastKnownLocation(provider!!)
            if (location != null) onLocationChanged(location)
            locationManager.requestLocationUpdates(provider, 20000, 0f, this)
        }
    }

    override fun onLocationChanged(location: Location) {
        val mLatitude = location.latitude
        val mLongitude = location.longitude
        val latLng = LatLng(mLatitude, mLongitude)
        mGoogleMap!!.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        mGoogleMap!!.animateCamera(CameraUpdateFactory.zoomTo(12f))
        setObserber(mLatitude, mLongitude)
    }

    private fun setObserber(mLatitude: Double, mLongitude: Double) {
        val factory = ViewModelFactory.getInstance(this)
        nearByViewModel = ViewModelProvider(this, factory)[NearByViewModel::class.java]

        nearByViewModel.getHospitalNearBy(mLatitude.toString(), mLongitude.toString())
            .observe(this, {
                displayMarker(it)
            })
    }

    private fun displayMarker(data: List<MapsEntity>) {
        mGoogleMap!!.clear()
        for (response in data) {
            val markerOptions = MarkerOptions()
            val pinDrop =
                BitmapDescriptorFactory.fromResource(R.drawable.ic_pin)
            val lat = response.latitude
            val lng = response.lng
            val namePlace = response.namePlace
            val nameStreet = response.nameStreet
            val latLng = LatLng(lat, lng)
            markerOptions.icon(pinDrop)
            markerOptions.position(latLng)
            markerOptions.title("$namePlace : $nameStreet")
            mGoogleMap!!.addMarker(markerOptions)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}