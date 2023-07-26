package com.example.task9kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import com.example.task9kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolBar=binding.materialToolbar

        toolBar.setNavigationOnClickListener {
        Toast.makeText(applicationContext,"nav Icon Clicked",Toast.LENGTH_LONG).show()

        }

    binding.bottomNavigation.setOnItemSelectedListener {
        when(it.itemId){
            R.id.home -> Toast.makeText(applicationContext,"home clicked",Toast.LENGTH_LONG).show()
            R.id.cashPoints-> Toast.makeText(applicationContext,"cash points clicked",Toast.LENGTH_LONG).show()
            R.id.Qr->Toast.makeText(applicationContext,"Qr clicked",Toast.LENGTH_LONG).show()
            R.id.bellicon->Toast.makeText(applicationContext,"Bell icon clicked",Toast.LENGTH_LONG).show()
            R.id.myAccount->Toast.makeText(applicationContext,"My Accout clicked",Toast.LENGTH_LONG).show()
        }
    true
    }



    }



}


