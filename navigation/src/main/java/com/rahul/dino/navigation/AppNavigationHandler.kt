package com.rahul.dino.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.rahul.dino.core.utils.Event

class AppNavigationHandler {
    private val _navigationController: MutableLiveData<Event<(NavController) -> Unit>> = MutableLiveData()
    val navigationController : LiveData<Event<(NavController) -> Unit>>
    get() = _navigationController

    fun emit(navController: (NavController) -> Unit){
        _navigationController.value = Event(navController)
    }
}