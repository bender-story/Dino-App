package com.rahul.pod.categories.di

import com.rahul.dino.core.network.ServiceType
import com.rahul.pod.categories.CategoryViewModel
import com.rahul.pod.categories.network.CategoryMockServiceImpl
import com.rahul.pod.categories.network.CategoryServiceApiHelper
import com.rahul.pod.categories.network.CategoryServiceInterface
import com.rahul.pod.categories.network.CategoryServiceRepo
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val categoryModule = module {
    factory { CategoryServiceRepo() }
    factory { (serviceType: ServiceType, baseURL: String) ->
        CategoryServiceApiHelper(CategoryServiceInterface::class.java, CategoryMockServiceImpl::class.java, serviceType, baseURL) }
    viewModel { CategoryViewModel() }

}