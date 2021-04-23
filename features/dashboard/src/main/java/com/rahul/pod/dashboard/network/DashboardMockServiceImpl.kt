package com.rahul.pod.dashboard.network

import com.rahul.pod.dashboard.data.CategoryDataResponse
import io.reactivex.Observable
import retrofit2.mock.BehaviorDelegate

class DashboardMockServiceImpl(private val delegate: BehaviorDelegate<DashboardServiceInterface>) : DashboardServiceInterface {

    override fun getDashboardData(): Observable<CategoryDataResponse> {
        TODO("Not yet implemented")
    }

    private fun getLoginJson(): String {
        return "{\"status\":\"Success\"}"
    }

}