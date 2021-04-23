package com.rahul.dino.navigation

import android.os.Bundle

interface AppNavigationInterface {
    fun openDashBoard()
    fun openCategoryScreen(bundle: Bundle)
    fun openProfileScreen()
    fun openNotificationScreen()
    fun openLogoutScreen()
}

enum class NavigationType{
    DASHBOARD,
    CATEGORY,
    LOGOUT,
    NOTIFICATION,
    PROFILE

}