package com.rahul.pod.login.di

import com.rahul.pod.login.LoginViewModel
import com.rahul.pod.login.network.LoginServiceRepo
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    factory { LoginServiceRepo() }
    viewModel { LoginViewModel() }

}