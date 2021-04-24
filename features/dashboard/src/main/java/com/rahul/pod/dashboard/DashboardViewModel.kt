package com.rahul.pod.dashboard

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rahul.dino.core.utils.Event
import com.rahul.pod.dashboard.data.AllCategoriesDataResponse
import com.rahul.pod.dashboard.network.DashboardServiceRepo
import org.koin.core.KoinComponent
import org.koin.core.inject

class DashboardViewModel:ViewModel(),KoinComponent {

    private val _categoryData = MutableLiveData<AllCategoriesDataResponse>()
    val allCategoriesData: LiveData<AllCategoriesDataResponse>
        get() = _categoryData

    private val _errorEvent = MutableLiveData<Event<Unit>>()
    val errorEvent: LiveData<Event<Unit>>
        get() = _errorEvent

    val loader: ObservableField<Boolean> = ObservableField()


     val serviceRepo: DashboardServiceRepo by inject()

    fun getDashBoardData() {
        loader.set(true)
        serviceRepo.getDashboardData(onSuccess = {
            loader.set(false)
            _categoryData.postValue(it)
        }, onError = {
            loader.set(false)
            _errorEvent.value = Event(Unit)
        })
    }

    override fun onCleared() {
        serviceRepo.dispose()
        super.onCleared()
    }

}