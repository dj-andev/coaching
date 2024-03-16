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
import com.andev.kranthi.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel
    private lateinit var loginBinding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Navigation_onCreate", "Login Reference : "+this)
    }

    override fun onResume() {
        super.onResume()
        Log.i("Navigation_onResume", "Login Reference : "+this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        return loginBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
/*        loginBinding.btnLogin.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToDashboardFragment()
            action.profileID = 1234
            action.profileName = "LogSampleProfile"
            findNavController().navigate(action)
//            findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
        }*/

        loginBinding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }
    }

}