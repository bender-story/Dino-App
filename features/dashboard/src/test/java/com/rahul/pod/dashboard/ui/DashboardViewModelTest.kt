package com.rahul.pod.dashboard.ui

import com.rahul.dino.core.utils.getOrAwaitValue
import com.rahul.pod.dashboard.DashboardBaseTest
import com.rahul.pod.dashboard.DashboardViewModel
import org.junit.Assert
import org.junit.Test


class DashboardViewModelTest : DashboardBaseTest() {
    var viewModel: DashboardViewModel? = null


    override fun beforeEach() {
        super.beforeEach()
        viewModel = DashboardViewModel()
    }

    @Test
    fun `get dashboard data on success`() {
        viewModel?.getDashBoardData().toString().apply {
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
}