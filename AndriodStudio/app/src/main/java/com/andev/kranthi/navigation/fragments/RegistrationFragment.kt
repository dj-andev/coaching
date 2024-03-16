package com.andev.kranthi.navigation.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.andev.kranthi.R
import com.andev.kranthi.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {

    companion object {
        fun newInstance() = RegistrationFragment()
    }

    private lateinit var viewModel: RegistrationViewModel
    private lateinit var bindingRegistration : FragmentRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Navigation_onCreate", "RegistrationFragment Reference : "+this)
    }

    override fun onResume() {
        super.onResume()
        Log.i("Navigation_onResume", "RegistrationFragment Reference : "+this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingRegistration = FragmentRegistrationBinding.inflate(inflater, container, false)
        return bindingRegistration.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)
        bindingRegistration.btnDashboard.setOnClickListener {
            val action = RegistrationFragmentDirections.actionRegistrationFragmentToDashboardFragment()
            action.profileID = 12345
            action.profileName = "RegSampleProfile"
            findNavController().navigate(action)
//            findNavController().navigate(R.id.action_registrationFragment_to_dashboardFragment)
        }
    }

}