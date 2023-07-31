package com.example.task9kotlin.homeFragment.moreWithEasyPaisa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.task9kotlin.R
import com.example.task9kotlin.databinding.FragmentMoreWithEasyPaisaBinding

class MoreWithEasyPaisa : Fragment() {
    lateinit private var binding : FragmentMoreWithEasyPaisaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
            binding = FragmentMoreWithEasyPaisaBinding.inflate(layoutInflater,container,false)
            return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    companion object {
        fun newInstance() = MoreWithEasyPaisa()
    }
}