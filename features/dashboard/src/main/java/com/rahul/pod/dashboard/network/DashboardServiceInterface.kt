package com.rahul.pod.dashboard.network

import com.rahul.pod.dashboard.data.AllCategoriesDataResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface DashboardServiceInterface {
    @GET("categories")
    fun getDashboardData(): Observable<AllCategoriesDataResponse>
}