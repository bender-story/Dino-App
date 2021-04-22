package com.rahul.pod.login.network

import com.google.gson.Gson
import com.rahul.pod.login.data.LoginDataRequest
import com.rahul.pod.login.data.LoginDataResponse
import io.reactivex.Observable
import retrofit2.mock.BehaviorDelegate

class LoginMockServiceImpl(private val delegate: BehaviorDelegate<LoginServiceInterface>) : LoginServiceInterface {
    override fun login(loginDataRequest: LoginDataRequest): Observable<LoginDataResponse> {
        var json: String = getLoginJson()

        val mockResponse = Gson().fromJson(json, LoginDataResponse::class.java)
        return delegate.returningResponse(mockResponse).login(LoginDataRequest("sample", "sample"))
    }

    private fun getLoginJson(): String {
        return "{\"status\":\"Success\"}"
    }
}