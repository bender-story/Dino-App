package com.rahul.pod.login.network

import com.rahul.dino.core.BaseTest
import com.rahul.dino.core.network.ServiceAPIHelper
import com.rahul.dino.core.network.ServiceType
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito

class LoginServiceRepoTest : BaseTest() {

    private var loginServiceRepo: LoginServiceRepo? = null

    override fun beforeEach() {
        super.beforeEach()
        loginServiceRepo = Mockito.mock(LoginServiceRepo::class.java)
        Mockito.`when`(loginServiceRepo?.serviceAPIHelper).thenReturn(
            ServiceAPIHelper(
                LoginServiceInterface::class.java, LoginMockServiceImpl::class.java,
                ServiceType.MOCK, ""
            )
        )
    }

    override fun afterEach() {
        super.afterEach()
    }

    @Test
    fun `get login when success`(){
        loginServiceRepo?.login("Sample","Sample",onSuccess = {
            Assert.assertTrue(it != null)
            Assert.assertEquals(it?.status,"Success")
        },onError = {
            assert(false)
        })
    }
}