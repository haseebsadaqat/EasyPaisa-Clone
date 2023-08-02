package com.example.task9kotlin.homeFragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.task9kotlin.dummyData.DummyDataClass

class HomeFragmentViewModel(application: Application) : AndroidViewModel(application) {
var dummyInstance = DummyDataClass()
var promoImagesArray= dummyInstance.mainPromoImagesArray
}