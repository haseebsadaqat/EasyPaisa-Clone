package com.example.task9kotlin.utils
import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentActivity

class PermissionUtils {
    fun checkCameraPermission(context: Context): Boolean{
        return ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    }
    fun getRequestCameraPermission(context: Activity){
        ActivityCompat.requestPermissions(
            context,
            arrayOf(Manifest.permission.CAMERA), Constants.locationCode)
    }
}