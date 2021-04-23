package com.rahul.pod.dashboard.network

import com.rahul.dino.core.network.NetworkConfigInterface
import com.rahul.pod.dashboard.data.AllCategoriesDataResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf

class DashboardServiceRepo : KoinComponent {
    private val networkConfig: NetworkConfigInterface by inject()
    private val serviceAPIHelper: DashBoardServiceApiHelper<DashboardServiceInterface,DashboardMockServiceImpl> by inject { parametersOf(networkConfig.getServiceType(), networkConfig.getBaseURL()) }

    // initialise disposable object to dump api calls
    private val disposable: CompositeDisposable = CompositeDisposable()

    /**
     * @param onSuccess success callback
     * @param onSuccess error callback
     */
    fun getDashboardData(
        onSuccess: (AllCategoriesDataResponse) -> Unit,
        onError: (String) -> Unit
    ) {

        disposable.add(serviceAPIHelper.serviceInterface!!.getDashboardData()
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

