package com.andev.kranthi.navigation.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.andev.kranthi.R
import com.andev.kranthi.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    companion object {
        fun newInstance() = DashboardFragment()
    }

    private lateinit var viewModel: DashboardViewModel
    private lateinit var binding: FragmentDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Navigation_onCreate", "DashboardFragment Reference : "+this)
    }

    override fun onResume() {
        super.onResume()
        Log.i("Navigation_onResume", "DashboardFragment Reference : "+this)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        val  profileId = DashboardFragmentArgs.fromBundle(requireArguments()).profileID
        val  profileName = DashboardFragmentArgs.fromBundle(requireArguments()).profileName
        binding.txtDashBoard.text = "User Info : $profileId, $profileName"

        binding.btnDashboard.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToLoginFragment()
            findNavController().navigate(action)
        }
    }

}