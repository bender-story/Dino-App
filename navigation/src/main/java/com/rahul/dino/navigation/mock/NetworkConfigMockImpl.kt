package com.rahul.dino.navigation.mock

import com.rahul.dino.core.network.NetworkConfigInterface
import com.rahul.dino.core.network.ServiceType

class NetworkConfigMockImpl : NetworkConfigInterface {
    override fun getBaseURL()= "https://91aa1e20-b217-4215-a9db-6c03e6b92774.mock.pstmn.io/dino/"

    override fun getServiceType()= ServiceType.MOCK
}