package com.example.task9kotlin.promotionsFragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.task9kotlin.dummyData.DummyDataClass

class PromoFragAdapterViewModel(application: Application) : AndroidViewModel(application) {

    var dummyInstance = DummyDataClass()
    var promoImagesArray= dummyInstance.mainPromoImagesArray

}