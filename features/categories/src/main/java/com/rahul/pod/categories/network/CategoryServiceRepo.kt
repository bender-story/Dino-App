package com.rahul.pod.categories.network

import com.rahul.dino.core.network.NetworkConfigInterface
import com.rahul.dino.core.network.ServiceAPIHelper
import com.rahul.pod.categories.data.CategoryDataResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

class CategoryServiceRepo:KoinComponent {
    private val networkConfig: NetworkConfigInterface by inject()
    private val serviceAPIHelper= ServiceAPIHelper(CategoryServiceInterface::class.java, CategoryMockServiceImpl::class.java, networkConfig.getServiceType(), networkConfig.getBaseURL())

    // initialise disposable object to dump api calls
    private val disposable: CompositeDisposable = CompositeDisposable()

    /**
     * get Category Data
     * @param onSuccess success callback
     * @param onSuccess error callback
     */
    fun getCategoryData(
        parentCategory: String,
        category: String,
        onSuccess: (CategoryDataResponse) -> Unit,
        onError: (String) -> Unit
    ) {

        disposable.add(serviceAPIHelper.serviceInterface!!.getCategoryData(parentCategory,category)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    onSuccess.invoke(result)
                },
                { error ->
                    onError.invoke(error.toString())
                }
            ))
    }

    /**
     * method to dump calls and release memory
     */
    fun dispose() {
        disposable.dispose()
    }
}