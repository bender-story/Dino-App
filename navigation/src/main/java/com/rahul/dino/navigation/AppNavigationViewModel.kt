package com.rahul.dino.navigation

import android.os.Bundle
import androidx.lifecycle.ViewModel

class AppNavigationViewModel(private val appNavigationInterface: AppNavigationInterface): ViewModel() {
    fun onNavigationClicked(navigationType: NavigationType,bundle: Bundle = Bundle() ){
        when(navigationType){
            NavigationType.PROFILE -> appNavigationInterface.openProfileScreen()
            NavigationType.CATEGORY -> appNavigationInterface.openCategoryScreen(bundle)
            NavigationType.DASHBOARD -> appNavigationInterface.openDashBoard()
            NavigationType.NOTIFICATION -> appNavigationInterface.openNotificationScreen()
            NavigationType.LOGOUT -> appNavigationInterface.openLogoutScreen()
        }
    }
}