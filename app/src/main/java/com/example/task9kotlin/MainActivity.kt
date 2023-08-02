package com.example.task9kotlin

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.task9kotlin.Qr_Code.Qr_Code_Fragment
import com.example.task9kotlin.accountSettings.AccountSettings_Frag
import com.example.task9kotlin.cashPoints.Cash_Points_Fragment
import com.example.task9kotlin.databinding.ActivityMainBinding
import com.example.task9kotlin.homeFragment.AppHomeFragment
import com.example.task9kotlin.myAccount.MyAccount
import com.example.task9kotlin.promotionsFragment.PromotionsFragment
import com.google.android.material.appbar.MaterialToolbar
class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var parentFrameLayout: Any
    private lateinit var toolBar: MaterialToolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialSetup()
        //nav icon listner
        navigationIconListener()
        //bottom navigation
        bottomNav()
    }

    private fun navigationIconListener() {
        toolBar.setNavigationOnClickListener {
            commonToolbarSetting()
        }
    }

    private fun bottomNav() {
        binding.bottomNavigation.setOnItemSelectedListener {
            var selectedFragment:Fragment? =null
            when(it.itemId){
                R.id.home -> {selectedFragment = AppHomeFragment()
                    toolBar.visibility=View.VISIBLE
                }
                R.id.cashPoints->{selectedFragment = Cash_Points_Fragment()
                    toolBar.visibility=View.GONE
                }
                R.id.Qr->{
                    selectedFragment = Qr_Code_Fragment()
                    toolBar.visibility=View.GONE
                }
                R.id.promos->{
                    selectedFragment = PromotionsFragment()
                    toolBar.visibility=View.GONE }
                R.id.myAccount->{
                    selectedFragment = AccountSettings_Frag()
                    toolBar.visibility=View.GONE
                }
            }
            supportFragmentManager.beginTransaction().replace(R.id.parentFrameLayout,selectedFragment ?: Fragment()).commit()
            true
        }
    }

    private fun initialSetup() {
        toolBar = binding.materialToolbar
        parentFrameLayout=binding.parentFrameLayout
        supportFragmentManager.beginTransaction().replace(R.id.parentFrameLayout,AppHomeFragment()).commit()
        //change status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.setStatusBarColor(getColor(R.color.themecolor))
        }
    }
    private fun commonToolbarSetting() {
       toolBar.visibility=View.GONE
        supportFragmentManager.beginTransaction().replace(R.id.parentFrameLayout,MyAccount.newInstance()).commit()
    }
}