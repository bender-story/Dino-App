package com.rahul.pod.navigation

import com.rahul.dino.navigation.AppNavigationHandler
import com.rahul.dino.navigation.AppNavigationInterface
import com.rahul.pod.R

class AppNavigationImpl(private val navigationHandler: AppNavigationHandler) :
    AppNavigationInterface {
    override fun openDashBoard() {
        navigationHandler.emit {
            
            it.navigate(R.id.nav_graph_dashboard,null)
        }
    }

    override fun openCategoryScreen() {
        navigationHandler.emit {
            
            it.navigate(R.id.nav_graph_category)
        }

    }

    override fun openProfileScreen() {
        navigationHandler.emit {
            
            it.navigate(R.id.nav_graph_profile)
        }
    }

    override fun openNotificationScreen() {
        navigationHandler.emit {
            
            it.navigate(R.id.nav_graph_notification)
        }
    }

    override fun openLogoutScreen() {
        navigationHandler.emit {
            
            it.navigate(R.id.nav_graph_logout)
        }
    }
}