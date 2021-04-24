package com.rahul.pod.dashboard.network

import com.rahul.pod.dashboard.DashboardBaseTest
import org.junit.Assert
import org.junit.Test


class DashboardServiceRepoTest : DashboardBaseTest() {

    private var serviceRepo: DashboardServiceRepo? = null

    override fun beforeEach() {
        super.beforeEach()
        serviceRepo = DashboardServiceRepo()
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