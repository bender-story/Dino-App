package com.rahul.pod.dashboard.ui

import com.rahul.dino.core.BaseTest
import com.rahul.dino.core.getOrAwaitValue
import com.rahul.dino.core.network.ServiceAPIHelper
import com.rahul.dino.core.network.ServiceType
import com.rahul.pod.dashboard.DashboardViewModel
import com.rahul.pod.dashboard.network.DashboardMockServiceImpl
import com.rahul.pod.dashboard.network.DashboardServiceInterface
import com.rahul.pod.dashboard.network.DashboardServiceRepo
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito

class LoginViewModelTest : BaseTest() {
    var viewModel: DashboardViewModel? = null

    override fun beforeEach() {
        super.beforeEach()
        viewModel = Mockito.mock(DashboardViewModel::class.java)

        Mockito.`when`(viewModel?.serviceRepo).thenReturn(
            Mockito.mock(DashboardServiceRepo::class.java)
        )

        Mockito.`when`(viewModel?.serviceRepo?.serviceAPIHelper).thenReturn(
            ServiceAPIHelper(
                DashboardServiceInterface::class.java, DashboardMockServiceImpl::class.java,
                ServiceType.MOCK, ""
            )
        )
    }

    @Test
    fun `get dashboard data on success`() {
        viewModel?.getDashBoardData()
        Assert.assertNotNull(viewModel?.allCategoriesData?.getOrAwaitValue())
        Assert.assertEquals(viewModel?.loader?.get(), false)

        Assert.assertEquals(
            viewModel?.allCategoriesData?.value?.categories?.get(0)?.title,
            "Stories"
        )
        Assert.assertEquals(
            viewModel?.allCategoriesData?.value?.categories?.get(0)?.values?.get(0)?.value,
            "All"
        )
        Assert.assertEquals(
            viewModel?.allCategoriesData?.value?.categories?.get(0)?.values?.get(1)?.value,
            "Kids"
        )

    }
}