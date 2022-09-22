package com.hfad.shoestore.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.hfad.shoestore.R
import com.hfad.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityBinding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding=DataBindingUtil.setContentView(this, R.layout.activity_main)
        initActionBar()
    }

    private fun initActionBar(){
        //setting the navHostFragment
        val navHostFragment=supportFragmentManager.findFragmentById(
            R.id.myNavHostFragment
        )as NavHostFragment

        navController=navHostFragment.navController

        //remove navigateUp buttons from the following fragments
        val appBarCustomization= AppBarConfiguration(
            setOf(
                R.id.loginFragment,
                R.id.welcomeScreen,
                R.id.shoeListFragment
            )
        )

        setupActionBarWithNavController(navController,appBarCustomization)
    }

    //support navigate up button
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()||super.onSupportNavigateUp()
    }
}