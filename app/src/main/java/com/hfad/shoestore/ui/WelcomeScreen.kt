package com.hfad.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.hfad.shoestore.R
import com.hfad.shoestore.databinding.FragmentWelcomeScreenBinding

class WelcomeScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val welcomeBinding:FragmentWelcomeScreenBinding=DataBindingUtil.inflate(inflater,
            R.layout.fragment_welcome_screen, container, false)

        //When pressing the button the app navigates to the fragment displaying the instructions
        welcomeBinding.instructionsBtn.setOnClickListener(
            Navigation.createNavigateOnClickListener(WelcomeScreenDirections.actionWelcomeScreenToInstructionFragment())
        )

        return welcomeBinding.root
    }


}