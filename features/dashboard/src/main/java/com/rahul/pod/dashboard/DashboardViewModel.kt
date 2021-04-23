package com.rahul.pod.dashboard

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rahul.dino.core.utils.Event
import com.rahul.pod.dashboard.data.CategoryDataResponse
import com.rahul.pod.dashboard.network.DashboardServiceRepo
import org.koin.core.KoinComponent
import org.koin.core.inject

class DashboardViewModel:ViewModel(),KoinComponent {

    private val _categoryData = MutableLiveData<CategoryDataResponse>()
    val categoryData: LiveData<CategoryDataResponse>
        get() = _categoryData

    private val _errorEvent = MutableLiveData<Event<Unit>>()
    val errorEvent: LiveData<Event<Unit>>
        get() = _errorEvent

    val loginLoader: ObservableField<Boolean> = ObservableField()


    private val serviceRepo: DashboardServiceRepo by inject()

    fun getDashBoardData() {
        loginLoader.set(true)
        serviceRepo.getDashboardData(onSuccess = {
            loginLoader.set(false)
            _categoryData.postValue(it)
        }, onError = {
            loginLoader.set(false)
            _errorEvent.value = Event(Unit)
        })
    }

    override fun onCleared() {
        serviceRepo.dispose()
        super.onCleared()
    }

}