package com.example.task9kotlin.Qr_Code
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.task9kotlin.MainActivity
import com.example.task9kotlin.databinding.FragmentQrCodeBinding
import com.example.task9kotlin.utils.PermissionUtils


class Qr_Code_Fragment : Fragment() {
    lateinit var binding: FragmentQrCodeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding=FragmentQrCodeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cameraSetup()
        backButtonListener()
    }

    private fun backButtonListener() {
        binding.arrowButtonMyAccount.setOnClickListener {
            onDestroy()
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
    }


    private fun openCamera() {
        val cameraintent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraintent,101)
    }
    private fun cameraSetup() {

            if (PermissionUtils().checkCameraPermission(requireContext())) {
                //open Camera
                openCamera()
            } else {
                PermissionUtils().getRequestCameraPermission(requireActivity())
            }
    }
    companion object {
       fun newInstance() = Qr_Code_Fragment()
    }
}