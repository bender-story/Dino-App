package com.rahul.pod.login

import androidx.databinding.ObservableField
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

    private val _loginErrorEvent = MutableLiveData<Event<Unit>>()
    val loginErrorEvent: LiveData<Event<Unit>>
        get() = _loginErrorEvent

    val loginLoader: ObservableField<Boolean> = ObservableField()


    val serviceRepo: LoginServiceRepo by inject()

    fun login(userName: String,
              password: String) {
        loginLoader.set(true)
        serviceRepo.login(userName, password, onSuccess = {
            loginLoader.set(false)
            _loginSuccessEvent.value = Event(Unit)
        }, onError = {
            loginLoader.set(false)
            _loginErrorEvent.value = Event(Unit)
        })
    }

    override fun onCleared() {
        serviceRepo.dispose()
        super.onCleared()
    }

}