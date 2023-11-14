package com.example.pokemonapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.pokemonapp.R
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        // for java.lang.SecurityException: writable dex file '.../code_cache/.overlay/base.apk/classes2.dex' is not allowed. error
        val dexOutputDir: File = codeCacheDir
        dexOutputDir.setReadOnly()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}