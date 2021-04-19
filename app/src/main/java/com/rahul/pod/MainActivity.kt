package com.rahul.pod

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.rahul.dino.navigation.AppNavigationHandler
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val navigationHandler: AppNavigationHandler by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        supportActionBar?.hide()
        initNavigator()
    }

    private fun initNavigator() {
        val navController = findNavController(R.id.nav_host_fragment)
        navigationHandler.navigationController.observe(this) {
            it.getContentIfNotHandledOrReturnNull().let { setNavController ->
                setNavController?.let { controller -> controller(navController) }
            }
        }
    }

}
