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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        BottomSheetBinding = binding.bottomSheeter.bottomSheet
        bottomSheetBehavior = BottomSheetBehavior.from(BottomSheetBinding)
        listenersWithCallback()
    }
    private fun listenersWithCallback() {
        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {

                when (newState) {
                    BottomSheetBehavior.STATE_EXPANDED ->{ getString(R.string.closeBSHEET)
                        binding.bottomSheeter.imageViewBottomSheet.apply {
                            setImageResource(R.drawable.baseline_keyboard_arrow_down_24)}

                    }
                    BottomSheetBehavior.STATE_COLLAPSED ->{ getString(R.string.openBsheet)
                        binding.bottomSheeter.imageViewBottomSheet.apply {
                            setImageResource(R.drawable.baseline_keyboard_arrow_up_24)}
                    }
                    else -> getString(R.string.defaultBsheet)
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