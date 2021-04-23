package com.rahul.pod.categories.network

import com.rahul.pod.categories.data.CategoryDataResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface CategoryServiceInterface {
    @GET("category/{parentCategory}/{category}")
    fun getCategoryData(@Path("parentCategory") parentCategory: String,@Path("category") category: String): Observable<CategoryDataResponse>
}