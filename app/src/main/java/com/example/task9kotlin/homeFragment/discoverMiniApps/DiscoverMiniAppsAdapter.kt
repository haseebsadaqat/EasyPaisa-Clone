package com.example.task9kotlin.homeFragment.discoverMiniApps

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.task9kotlin.homeFragment.moreWithEasyPaisa.MoreWithEasyPaisa
import com.example.task9kotlin.homeFragment.moreWithEasyPaisa.MoreWithEasyPaisa_page2

class DiscoverMiniAppsAdapter(fragmentManager: FragmentManager,
                              lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return MiniAppFragment1.newInstance()
            1 -> return MiniAppFragment2.newInstance()
            else -> return MiniAppFragment1.newInstance()
        }
    }

}