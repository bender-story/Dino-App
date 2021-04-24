package com.rahul.pod.dashboard.network

import com.rahul.dino.core.BaseTest
import com.rahul.dino.core.network.ServiceAPIHelper
import com.rahul.dino.core.network.ServiceType
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito

class DashboardServiceRepoTest : BaseTest() {

    private var serviceRepo: DashboardServiceRepo? = null

    override fun beforeEach() {
        super.beforeEach()
        serviceRepo = Mockito.mock(DashboardServiceRepo::class.java)
        Mockito.`when`(serviceRepo?.serviceAPIHelper).thenReturn(
            ServiceAPIHelper(
                DashboardServiceInterface::class.java, DashboardMockServiceImpl::class.java,
                ServiceType.MOCK, ""
            )
        )
    }

    override fun afterEach() {
        super.afterEach()
    }

    @Test
    fun `get Dashboard when success`() {
        serviceRepo?.getDashboardData(onSuccess = {
            Assert.assertTrue(it != null)
            Assert.assertEquals(it?.categories[0].title, "Stories")
            Assert.assertEquals(it?.categories[0].values[0].value, "All")
            Assert.assertEquals(it?.categories[0].values[1].value, "Kids")
        }, onError = {
            assert(false)
        })
    }
}