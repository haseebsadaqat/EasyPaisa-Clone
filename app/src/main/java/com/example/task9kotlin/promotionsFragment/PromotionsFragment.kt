package com.example.task9kotlin.promotionsFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.task9kotlin.MainActivity
import com.example.task9kotlin.R
import com.example.task9kotlin.databinding.ActivityMainBinding
import com.example.task9kotlin.databinding.FragmentMyAccountBinding
import com.example.task9kotlin.databinding.FragmentPromotionsBinding
import com.example.task9kotlin.homeFragment.HomeFragmentViewModel
import com.example.task9kotlin.myAccount.MyAccount

class PromotionsFragment : Fragment() {
    lateinit private var binding : FragmentPromotionsBinding
    private lateinit var viewModel: PromoFragAdapterViewModel
    var adapter = PromoFragAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPromotionsBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireNotNull(this.activity)
        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory(activity.application)).get(PromoFragAdapterViewModel::class.java)
        binding.arrowImageButtonPromo.setOnClickListener {
            onDestroy()
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
        binding.promoFragmentRecyclerView.adapter = adapter
        binding.promoFragmentRecyclerView.layoutManager = LinearLayoutManager(context, VERTICAL,false )
        adapter.setImagesIntergerArray(viewModel.promoImagesArray)
    }
    companion object {
        fun newInstance() = PromotionsFragment()
    }
}