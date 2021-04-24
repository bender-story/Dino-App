package com.rahul.pod.network

import com.rahul.dino.core.network.NetworkConfigInterface
import com.rahul.dino.core.network.ServiceType
import com.rahul.pod.Constants.DINO_API_BASE_URL

class NetworkConfigImpl : NetworkConfigInterface {
    override fun getBaseURL(): String {
        return DINO_API_BASE_URL
    }

    override fun getServiceType(): ServiceType {
        return ServiceType.MOCK
    }

}