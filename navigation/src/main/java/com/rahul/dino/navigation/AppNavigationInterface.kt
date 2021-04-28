package com.rahul.dino.navigation

import android.os.Bundle

interface AppNavigationInterface {
    fun navigateTo(navigationType: NavigationType, bundle: Bundle? = Bundle.EMPTY)
}

enum class NavigationType {
    DASHBOARD,
    CATEGORY,
    LOGOUT,
    NOTIFICATION,
    PROFILE,
    LOGIN

}