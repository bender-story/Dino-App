package com.rahul.pod.di

import com.rahul.dino.core.network.NetworkConfigInterface
import com.rahul.dino.navigation.AppNavigationHandler
import com.rahul.dino.navigation.AppNavigationInterface
import com.rahul.dino.navigation.AppNavigationViewModel
import com.rahul.pod.navigation.AppNavigationImpl
import com.rahul.pod.network.NetworkConfigImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var appModule = module {
    single { AppNavigationHandler() }
    single<AppNavigationInterface>{AppNavigationImpl(get())}
    single<NetworkConfigInterface>{NetworkConfigImpl()}
    viewModel { AppNavigationViewModel(get()) }
}