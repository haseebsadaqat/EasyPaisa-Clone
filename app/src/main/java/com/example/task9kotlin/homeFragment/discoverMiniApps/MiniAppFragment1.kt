package com.example.task9kotlin.homeFragment.discoverMiniApps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.task9kotlin.R
import com.example.task9kotlin.databinding.FragmentMiniApp1Binding
import com.example.task9kotlin.databinding.FragmentMoreWithEasyPaisaBinding
import com.example.task9kotlin.homeFragment.moreWithEasyPaisa.MoreWithEasyPaisa


class MiniAppFragment1 : Fragment() {
    lateinit private var binding : FragmentMiniApp1Binding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMiniApp1Binding.inflate(layoutInflater,container,false)
        return binding.root
      //  return inflater.inflate(R.layout.fragment_mini_app1, container, false)
    }

    companion object {
        fun newInstance() = MiniAppFragment1()

    }
}