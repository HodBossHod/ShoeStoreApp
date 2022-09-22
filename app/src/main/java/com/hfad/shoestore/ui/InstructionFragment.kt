package com.hfad.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.hfad.shoestore.R
import com.hfad.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val instructionFragmentBinding:FragmentInstructionBinding=DataBindingUtil.inflate(
            inflater, R.layout.fragment_instruction, container, false)

        //When pressing the button the app navigates to the fragment displaying the list of shoes
        instructionFragmentBinding.instructionsBtn.setOnClickListener(
            Navigation.createNavigateOnClickListener(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
        )

        return instructionFragmentBinding.root
    }


}