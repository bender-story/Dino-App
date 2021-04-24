package com.rahul.pod.categories

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rahul.dino.core.utils.Event
import com.rahul.pod.categories.data.CategoryDataResponse
import com.rahul.pod.categories.network.CategoryServiceRepo
import org.koin.core.KoinComponent
import org.koin.core.inject

class CategoryViewModel:ViewModel(), KoinComponent {
    private val _categoryData = MutableLiveData<CategoryDataResponse>()
    val categoryData: LiveData<CategoryDataResponse>
        get() = _categoryData

    private val _errorEvent = MutableLiveData<Event<Unit>>()
    val errorEvent: LiveData<Event<Unit>>
        get() = _errorEvent

    val loader: ObservableField<Boolean> = ObservableField()


     val serviceRepo: CategoryServiceRepo by inject()

    fun getCategoryData(parentCategory: String,
                        category: String) {
        loader.set(true)
        serviceRepo.getCategoryData(parentCategory,category,onSuccess = {
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