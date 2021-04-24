package com.rahul.pod.dashboard.di

import com.rahul.pod.dashboard.DashboardViewModel
import com.rahul.pod.dashboard.network.DashboardServiceRepo
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dashboardModule = module {
    factory { DashboardServiceRepo() }
    viewModel { DashboardViewModel() }

}