package com.example.task9kotlin
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.task9kotlin.databinding.ActivityMainBinding
import com.example.task9kotlin.databinding.CommonToolbarBinding
import com.example.task9kotlin.homeFragment.AppHomeFragment
import com.example.task9kotlin.homeFragment.discoverMiniApps.MiniAppFragment1
import com.example.task9kotlin.myAccount.MyAccount
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var parentFrameLayout: Any
    private lateinit var toolBar: MaterialToolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolBar = binding.materialToolbar
        parentFrameLayout=binding.parentFrameLayout

        toolBar.setNavigationOnClickListener {
            commonToolbarSetting()
        }
        //commonTool bar for other fragments
    binding.bottomNavigation.setOnItemSelectedListener {
        var selectedFragment:Fragment? =null
        when(it.itemId){
            R.id.home -> {selectedFragment = AppHomeFragment()
                toolBar.visibility=View.VISIBLE
            }
            R.id.cashPoints-> Toast.makeText(applicationContext,"cash points clicked",Toast.LENGTH_LONG).show()
            R.id.Qr->Toast.makeText(applicationContext,"Qr clicked",Toast.LENGTH_LONG).show()
            R.id.bellicon->Toast.makeText(applicationContext,"Bell icon clicked",Toast.LENGTH_LONG).show()
            R.id.myAccount->Toast.makeText(applicationContext,"My Accout clicked",Toast.LENGTH_LONG).show()
        }
        supportFragmentManager.beginTransaction().replace(R.id.parentFrameLayout,selectedFragment ?: Fragment()).commit()
    true
    }
    }

    private fun commonToolbarSetting() {
       toolBar.visibility=View.GONE
        supportFragmentManager.beginTransaction().replace(R.id.parentFrameLayout,MyAccount.newInstance()).commit()
        Toast.makeText(applicationContext,"nav Icon Clicked",Toast.LENGTH_LONG).show()
    }

    private fun homeScreenToolbarSetting() {
        toolBar.setNavigationIcon(R.drawable.baseline_profiler_pin_24)
        toolBar.clearNavigationIconTint()
        toolBar.setTitle(R.string.application_name)
        toolBar.isTitleCentered=true
        toolBar.setBackgroundColor(getColor(R.color.themecolor))
    }
}