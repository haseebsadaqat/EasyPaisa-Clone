package com.example.task9kotlin.homeFragment.moreWithEasyPaisa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.task9kotlin.R
import com.example.task9kotlin.databinding.FragmentMoreWithEasyPaisaBinding
import com.example.task9kotlin.databinding.FragmentMoreWithEasyPaisaPage2Binding

class MoreWithEasyPaisa_page2 : Fragment() {
    lateinit private var binding : FragmentMoreWithEasyPaisaPage2Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMoreWithEasyPaisaPage2Binding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    companion object {
        fun newInstance() = MoreWithEasyPaisa_page2()

    }
}