package com.rahul.pod.login.ui

import com.rahul.dino.core.utils.getOrAwaitValue
import com.rahul.pod.login.LoginBaseTest
import com.rahul.pod.login.LoginViewModel
import io.reactivex.rxkotlin.toSingle
import org.junit.Assert
import org.junit.Test


class LoginViewModelTest : LoginBaseTest() {
    private var loginViewModel: LoginViewModel? = null


    override fun beforeEach() {
        super.beforeEach()
        loginViewModel = LoginViewModel()
    }

    @Test
    fun `on login success`() {
        loginViewModel?.login("Sample", "Sample")?.toSingle().apply {
            Assert.assertNotNull(loginViewModel?.loginSuccessEvent?.getOrAwaitValue())
            Assert.assertEquals(loginViewModel?.loginLoader?.get(), false)
        }
    }
}