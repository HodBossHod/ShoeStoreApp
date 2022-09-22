package com.hfad.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.hfad.shoestore.R
import com.hfad.shoestore.classes.Shoe
import com.hfad.shoestore.converter.IntConverter
import com.hfad.shoestore.databinding.FragmentShoeDetailBinding
import com.hfad.shoestore.viewmodels.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var shoeDetailFragmentBinding:FragmentShoeDetailBinding
    private val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        shoeDetailFragmentBinding=DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_detail, container, false)

        shoeDetailFragmentBinding.cancelBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }


        shoeDetailFragmentBinding.saveBtn.setOnClickListener{
            if(shoeDetailFragmentBinding.editName.text ==null || shoeDetailFragmentBinding.editCompany.text==null
                || shoeDetailFragmentBinding.editSize.text ==null ||
                shoeDetailFragmentBinding.editDescription.text ==null){
                Toast.makeText(context,"Please fill all shoes details",Toast.LENGTH_LONG).show()
            }else {
                addShoeFromInput()
                Navigation.findNavController(it)
                    .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
            }
        }
        return shoeDetailFragmentBinding.root
    }

    private fun addShoeFromInput(){
        val name=shoeDetailFragmentBinding.editName.text.toString()
        val company=shoeDetailFragmentBinding.editCompany.text.toString()
        val size=shoeDetailFragmentBinding.editSize.text.toString()
        val description=shoeDetailFragmentBinding.editDescription.text.toString()

        val newShoe= Shoe(name,company, IntConverter.stringToInt(size),description)
        shoeViewModel.addShoe(newShoe)
    }


}