package com.rahul.dino.navigation

import android.os.Bundle
import androidx.lifecycle.ViewModel

class AppNavigator(private val appNavigationInterface: AppNavigationInterface) {
    fun onNavigationClicked(navigationType: NavigationType, bundle: Bundle = Bundle()) {
        appNavigationInterface.navigateTo(navigationType, bundle)
    }
}