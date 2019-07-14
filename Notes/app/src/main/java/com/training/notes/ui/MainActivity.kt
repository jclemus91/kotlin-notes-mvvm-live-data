package com.training.notes.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.training.notes.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navigator: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setUpNavigationController()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navigateUp(navigator, null)
    }

    private fun setUpNavigationController() {
        navigator = Navigation.findNavController(this, R.id.nav_host_fragment)
        setupActionBarWithNavController(navigator)
    }
}
