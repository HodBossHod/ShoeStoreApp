package com.hfad.shoestore.ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.hfad.shoestore.R
import com.hfad.shoestore.databinding.FragmentShoeListBinding
import com.hfad.shoestore.databinding.ShoeItemBinding
import com.hfad.shoestore.viewmodels.ShoeViewModel


class ShoeListFragment : Fragment(),MenuProvider {


    private val shoeViewModel: ShoeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val menuHost:MenuHost=requireActivity()
        menuHost.addMenuProvider(this,viewLifecycleOwner,Lifecycle.State.RESUMED)

        val shoeListBinding:FragmentShoeListBinding=DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_list, container, false)


        shoeListBinding.floatingActionButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        )

        shoeViewModel.shoeList.observe(viewLifecycleOwner, Observer {
            //for each shoes item
            it.forEach()
            {
                    val shoeItemBinding=ShoeItemBinding.inflate(LayoutInflater.from(requireContext()),shoeListBinding.listOfShoes,false)
                    shoeItemBinding.shoe=it
                    shoeListBinding.listOfShoes.addView(shoeItemBinding.root)
            }
        })

        return shoeListBinding.root
    }
    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.overflow_menu,menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

        when(menuItem.itemId){
            R.id.loginFragment -> findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        }
        return NavigationUI.onNavDestinationSelected(menuItem,requireView().findNavController())
    }

}