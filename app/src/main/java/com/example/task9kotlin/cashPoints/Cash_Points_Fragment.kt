package com.example.task9kotlin.cashPoints

import android.content.Intent
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.task9kotlin.MainActivity
import com.example.task9kotlin.R
import com.example.task9kotlin.databinding.BottomSheetPersistentBinding
import com.example.task9kotlin.databinding.FragmentCashPointsBinding

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior

class Cash_Points_Fragment : Fragment() {
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
   private lateinit var binding : FragmentCashPointsBinding
   //BottomSheetPersistentBinding
   private lateinit var BottomSheetBinding : ConstraintLayout


    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCashPointsBinding.inflate(inflater,container,false)
      //   BottomSheetBinding = BottomSheetPersistentBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
  /*      val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)*/


        BottomSheetBinding = binding.bottomSheeter.bottomSheet

            bottomSheetBehavior = BottomSheetBehavior.from(BottomSheetBinding)

        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {

                when (newState) {
                    BottomSheetBehavior.STATE_EXPANDED ->{ "Close Persistent Bottom Sheet"
                        binding.bottomSheeter.imageViewBottomSheet.apply {
                            setImageResource(R.drawable.baseline_keyboard_arrow_up_24)}

                    }
                    BottomSheetBehavior.STATE_COLLAPSED ->{ "Open Persistent Bottom Sheet"
                        binding.bottomSheeter.imageViewBottomSheet.apply {
                            setImageResource(R.drawable.baseline_keyboard_arrow_down_24)}
                    }
                    else -> "Persistent Bottom Sheet"
                }
            }
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }
        })
        binding.arrowImageButtonCashPoint.setOnClickListener {
            onDestroy()
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }

    binding.bottomSheeter.imageViewBottomSheet.setOnClickListener {
        val state = if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED)
                        BottomSheetBehavior.STATE_COLLAPSED
                    else
                        BottomSheetBehavior.STATE_EXPANDED
        bottomSheetBehavior.state = state
    }
    }
}