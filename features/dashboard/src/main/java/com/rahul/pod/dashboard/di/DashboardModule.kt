package com.rahul.pod.dashboard.di

import com.rahul.dino.core.network.ServiceType
import com.rahul.pod.dashboard.DashboardViewModel
import com.rahul.pod.dashboard.network.DashBoardServiceApiHelper
import com.rahul.pod.dashboard.network.DashboardMockServiceImpl
import com.rahul.pod.dashboard.network.DashboardServiceInterface
import com.rahul.pod.dashboard.network.DashboardServiceRepo
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dashboardModule = module {
    factory { DashboardServiceRepo() }
    factory { (serviceType: ServiceType, baseURL: String) ->
        DashBoardServiceApiHelper(DashboardServiceInterface::class.java, DashboardMockServiceImpl::class.java, serviceType, baseURL) }
    viewModel { DashboardViewModel() }

}