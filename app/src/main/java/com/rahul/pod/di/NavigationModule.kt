package com.rahul.pod.di

import com.rahul.dino.navigation.AppNavigationHandler
import com.rahul.dino.navigation.AppNavigationInterface
import com.rahul.dino.navigation.AppNavigationViewModel
import com.rahul.pod.navigation.AppNavigationImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var navigationModule = module {
    single { AppNavigationHandler() }
    single<AppNavigationInterface>{AppNavigationImpl(get())}
    viewModel { AppNavigationViewModel(get()) }
}