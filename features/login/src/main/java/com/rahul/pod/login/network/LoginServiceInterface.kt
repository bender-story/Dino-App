package com.rahul.pod.login.network

import com.rahul.pod.login.data.LoginDataRequest
import com.rahul.pod.login.data.LoginDataResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginServiceInterface {
    @POST("login")
    fun login(@Body loginDataRequest: LoginDataRequest): Observable<LoginDataResponse>
}