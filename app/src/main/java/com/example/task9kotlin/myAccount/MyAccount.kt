package com.example.task9kotlin.myAccount

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.task9kotlin.MainActivity
import com.example.task9kotlin.databinding.FragmentMyAccountBinding


class MyAccount : Fragment() {
    lateinit private var binding : FragmentMyAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyAccountBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.arrowImageButton.setOnClickListener {
            onDestroy()
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
         /*   requireActivity().supportFragmentManager.beginTransaction()
                .replace(com.example.task9kotlin.R.id.parentFrameLayout, AppHomeFragment.newInstance()).commit()*/

        }
    }

    companion object {
        fun newInstance() = MyAccount()
    }
}