package com.hfad.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.hfad.shoestore.R
import com.hfad.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentLoginBinding=DataBindingUtil.inflate(inflater,
            R.layout.fragment_login, container, false)

        //Pressing either button navigates to the Welcome Screen
        binding.createLoginBtn.setOnClickListener(
            Navigation.createNavigateOnClickListener(LoginFragmentDirections.actionLoginFragmentToWelcomeScreen())
        )

        binding.loginBtn.setOnClickListener(
            Navigation.createNavigateOnClickListener(LoginFragmentDirections.actionLoginFragmentToWelcomeScreen())
        )
        return binding.root
    }


}