package com.rahul.dino.navigation

interface AppNavigationInterface {
    fun openDashBoard()
    fun openCategoryScreen()
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