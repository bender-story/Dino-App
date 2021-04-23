package com.rahul.pod.dashboard.network

import com.rahul.dino.core.network.ServiceAPIHelper
import com.rahul.dino.core.network.ServiceType

class DashBoardServiceApiHelper<T, R: T>(
    serviceInterfaceClass: Class<T>,
    mockServiceImpl: Class<R>,
    serviceType: ServiceType,
    baseURL: String?
) : ServiceAPIHelper<T,R>(serviceInterfaceClass,mockServiceImpl,serviceType,baseURL){
}