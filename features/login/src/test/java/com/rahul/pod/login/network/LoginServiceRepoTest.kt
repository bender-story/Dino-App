package com.rahul.pod.login.network

import com.rahul.pod.login.LoginBaseTest
import org.junit.Assert
import org.junit.Test

class LoginServiceRepoTest : LoginBaseTest() {

    private var loginServiceRepo: LoginServiceRepo? = null
    override fun beforeEach() {
        super.beforeEach()
        loginServiceRepo = LoginServiceRepo()
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