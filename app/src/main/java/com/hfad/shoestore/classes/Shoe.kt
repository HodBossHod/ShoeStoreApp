package com.hfad.shoestore.classes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(
    var shoeName:String = "",
    var shoeCompany: String = "",
    var shoeSize: Int? = null,
    var shoeDescription:String = ""
) : Parcelable