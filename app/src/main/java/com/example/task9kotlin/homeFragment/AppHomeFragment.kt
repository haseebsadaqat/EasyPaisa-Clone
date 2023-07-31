package com.example.task9kotlin.homeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.task9kotlin.MainActivity
import com.example.task9kotlin.R
import com.example.task9kotlin.databinding.ActivityMainBinding
import com.example.task9kotlin.databinding.FragmentAppHomeBinding
import com.example.task9kotlin.homeFragment.discoverMiniApps.DiscoverMiniAppsAdapter
import com.example.task9kotlin.homeFragment.mainScreenPromotions.PromotionsAdapter

class AppHomeFragment : Fragment() {
    private lateinit var binding:FragmentAppHomeBinding
    private lateinit var viewModel: HomeFragmentViewModel
    val mainPromoAdapter= PromotionsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding= FragmentAppHomeBinding.inflate(layoutInflater,container,false)

        //inflater.inflate(R.layout.fragment_app_home, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val toolbarBinder = ActivityMainBinding.inflate(layoutInflater)
        toolbarBinder.materialToolbar.visibility=View.VISIBLE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireNotNull(this.activity)
        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory(activity.application)).get(HomeFragmentViewModel::class.java)

        // More With Easypaisa view Pager
        val adapter = ViewPagerAdapter(childFragmentManager,lifecycle)
        binding.moreWithEaseViewPager.adapter = adapter
        binding.moreWithEaseViewPager.setCurrentItem(0,true)

        //MainScreenPromotions Recycler View
        binding.mainPromotionsRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        mainPromoAdapter.setImagesList(viewModel.promoImagesArray)
        binding.mainPromotionsRecyclerView.adapter = mainPromoAdapter

        //Discover Mini Apps View Pager
        val discoverMiniApp_Adapter= DiscoverMiniAppsAdapter(childFragmentManager,lifecycle)
        binding.discoverMiniAppsPager.adapter=discoverMiniApp_Adapter
        binding.discoverMiniAppsPager.setCurrentItem(0,true)
    }

companion object{
    fun newInstance() = AppHomeFragment()

}
    }




