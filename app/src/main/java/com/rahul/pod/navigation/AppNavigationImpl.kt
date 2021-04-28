package com.rahul.pod.navigation

import android.os.Bundle
import androidx.navigation.navOptions
import com.rahul.dino.navigation.AppNavigationHandler
import com.rahul.dino.navigation.AppNavigationInterface
import com.rahul.dino.navigation.NavigationType
import com.rahul.pod.R

class AppNavigationImpl(private val navigationHandler: AppNavigationHandler) :
    AppNavigationInterface {
     private fun openDashBoard() {
        navigationHandler.emit {
            it.navigate(R.id.nav_graph_dashboard,null, navOptions { popUpTo(R.id.nav_graph_login){inclusive = false} })
        }
    }

     private fun openCategoryScreen(bundle: Bundle) {
        navigationHandler.emit {
            it.navigate(R.id.nav_graph_category,bundle)
        }

    }

     private fun openProfileScreen() {
        navigationHandler.emit {
            it.navigate(R.id.nav_graph_profile)
        }
    }

     private fun openNotificationScreen() {
        navigationHandler.emit {
            it.navigate(R.id.nav_graph_notification)
        }
    }

     private fun openLogoutScreen() {
        navigationHandler.emit {
            it.navigate(R.id.nav_graph_logout,null, navOptions { popUpTo(R.id.nav_graph_dashboard){inclusive = false} })
        }
    }

    private fun openLoginScreen() {
        navigationHandler.emit {
            it.navigate(R.id.nav_graph_login,null, navOptions { popUpTo(R.id.nav_graph_logout){inclusive = false} })
        }
    }

    override fun navigateTo(navigationType: NavigationType, bundle: Bundle?) {
        when (navigationType){
            NavigationType.PROFILE -> openProfileScreen()
            NavigationType.CATEGORY -> bundle?.let { openCategoryScreen(it) }
            NavigationType.DASHBOARD -> openDashBoard()
            NavigationType.NOTIFICATION -> openNotificationScreen()
            NavigationType.LOGOUT -> openLogoutScreen()
            NavigationType.LOGIN -> openLoginScreen()
        }
    }
}