package com.hfad.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hfad.shoestore.classes.Shoe

class ShoeViewModel:ViewModel() {

    private val _shoeList=MutableLiveData<MutableList<Shoe>>()
    val shoeList:LiveData<MutableList<Shoe>>
    get() = _shoeList

    private val _eventAdded=MutableLiveData<Boolean>()


    init {
        _shoeList.value= mutableListOf(
            Shoe("F50","Adidas",37,"Football boots"),
            Shoe("XSpeedPortal","Adidas",40,"September collection boots"),
            Shoe("Hypervenom","Nike",41,"Football boots sponsored by Neymar"),
            Shoe("Tod's-Suede","Clarks",43,"Classic shoes"),
            Shoe("Chuck Taylor","Converse",42,"Casual Converse shoes"),
            Shoe("Davis","Timberland",39,"Unisex's square leather boots"),
            Shoe("Ultra Flex 2","Skechers",38,"Walking shoes for women")
        )
    }

    fun addShoe(shoe: Shoe){
        shoeList.value?.add(shoe)
        _eventAdded.value=true
    }

}