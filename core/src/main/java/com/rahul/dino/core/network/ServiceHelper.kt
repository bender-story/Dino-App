package com.rahul.dino.core.network

import com.rahul.dino.core.utils.filterEmpty
import retrofit2.mock.BehaviorDelegate
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior

/**
 * Service helper class that helps to create either service Interface
 * Mock service Interface
 *
 */
open class ServiceAPIHelper<T, R: T>(
        serviceInterfaceClass: Class<T>,
        mockServiceImpl: Class<R>,
        serviceType: ServiceType,
        baseURL: String?
) {
    private var _serviceInterface: T? = null
     val serviceInterface: T?
    get() = _serviceInterface

    init {
        _serviceInterface = when (serviceType) {
            ServiceType.API ->
                NetworkAPIController.getApiClient(baseURL.filterEmpty())?.create(
                        serviceInterfaceClass)
            ServiceType.MOCK -> createMockServiceImpl(serviceInterfaceClass,mockServiceImpl, baseURL.filterEmpty())
        }
    }

//    fun getServiceInterface(): T? {
//        return serviceInterface
//    }

    /**
     * returns a mock service interface object
     */
    private fun createMockServiceImpl(serviceInterfaceClass: Class<T>, mockServiceImpl: Class<R>, baseURL: String): T? {
        val retrofit = NetworkAPIController.getApiClient(baseURL)
        val behavior = NetworkBehavior.create()
        val mockRetrofit = MockRetrofit.Builder(retrofit).networkBehavior(behavior).build()
        val delegate: BehaviorDelegate<T>? = mockRetrofit.create(serviceInterfaceClass)
        return mockServiceImpl.getConstructor(delegate?.javaClass).newInstance(delegate)
    }
}

enum class ServiceType {
    API,
    MOCK
}