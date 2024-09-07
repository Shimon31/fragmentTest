package com.example.fragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolBar.root)

        val drawerLayout = binding.drawerLayout
        val navView = binding.navigationView

        navController = findNavController(R.id.fragmentContainerView)

        appBarConfiguration = AppBarConfiguration(

            setOf(
                R.id.homeFragment,
                R.id.loginFragment,
                R.id.userFragment

            ), drawerLayout


        )

        setupActionBarWithNavController(navController, drawerLayout)
        navView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {

        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}