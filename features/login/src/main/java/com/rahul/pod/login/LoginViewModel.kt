package com.rahul.pod.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rahul.dino.core.utils.Event
import com.rahul.pod.login.network.LoginServiceRepo
import org.koin.core.KoinComponent
import org.koin.core.inject


class LoginViewModel : ViewModel(), KoinComponent {
    private val _loginSuccessEvent = MutableLiveData<Event<Unit>>()
    val loginSuccessEvent: LiveData<Event<Unit>>
        get() = _loginSuccessEvent
    private val serviceRepo: LoginServiceRepo by inject()

    fun login(userName: String,
              password: String) {
        serviceRepo.login(userName, password, onSuccess = {
            _loginSuccessEvent.value = Event(Unit)
        }, onError = {})
    }

    override fun onCleared() {
        serviceRepo.dispose()
        super.onCleared()
    }

}