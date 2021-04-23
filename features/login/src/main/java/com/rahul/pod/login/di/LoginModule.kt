package com.rahul.pod.login.di

import com.rahul.dino.core.network.ServiceType
import com.rahul.pod.login.LoginViewModel
import com.rahul.pod.login.network.LoginMockServiceImpl
import com.rahul.pod.login.network.LoginServiceAPIHelper
import com.rahul.pod.login.network.LoginServiceInterface
import com.rahul.pod.login.network.LoginServiceRepo
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    factory { LoginServiceRepo() }
    factory { (serviceType: ServiceType, baseURL: String) ->
        LoginServiceAPIHelper(LoginServiceInterface::class.java, LoginMockServiceImpl::class.java, serviceType, baseURL) }
    viewModel { LoginViewModel() }

}