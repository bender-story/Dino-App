package com.rahul.pod.login.ui

import com.rahul.dino.core.BaseTest
import com.rahul.dino.core.getOrAwaitValue
import com.rahul.dino.core.network.ServiceAPIHelper
import com.rahul.dino.core.network.ServiceType
import com.rahul.pod.login.LoginViewModel
import com.rahul.pod.login.network.LoginMockServiceImpl
import com.rahul.pod.login.network.LoginServiceInterface
import com.rahul.pod.login.network.LoginServiceRepo
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito

class LoginViewModelTest : BaseTest() {
    var loginViewModel : LoginViewModel? = null

    override fun beforeEach() {
        super.beforeEach()
        loginViewModel = Mockito.mock(LoginViewModel::class.java)

        Mockito.`when`(loginViewModel?.serviceRepo).thenReturn(
            Mockito.mock( LoginServiceRepo::class.java)
        )

        Mockito.`when`(loginViewModel?.serviceRepo?.serviceAPIHelper).thenReturn(
            ServiceAPIHelper(
                LoginServiceInterface::class.java, LoginMockServiceImpl::class.java,
                ServiceType.MOCK, ""
            )
        )
    }

    @Test
    fun `on login success`(){
        loginViewModel?.login("Sample","Sample")
        Assert.assertNotNull(loginViewModel?.loginSuccessEvent?.getOrAwaitValue())
        Assert.assertEquals(loginViewModel?.loginLoader?.get(),false)

    }
}