package com.example.task9kotlin.accountSettings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.task9kotlin.R
import com.example.task9kotlin.databinding.FragmentAccountSettingsBinding
class AccountSettings_Frag : Fragment() {
    lateinit var binding : FragmentAccountSettingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentAccountSettingsBinding.inflate(inflater,container,false).root
    }

    companion object {
        fun newInstance() = AccountSettings_Frag()
    }
}