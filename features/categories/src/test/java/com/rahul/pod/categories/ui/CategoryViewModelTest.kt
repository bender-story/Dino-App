package com.rahul.pod.categories.ui

import com.rahul.dino.core.BaseTest
import com.rahul.dino.core.getOrAwaitValue
import com.rahul.dino.core.network.ServiceAPIHelper
import com.rahul.dino.core.network.ServiceType
import com.rahul.pod.categories.CategoryViewModel
import com.rahul.pod.categories.network.CategoryMockServiceImpl
import com.rahul.pod.categories.network.CategoryServiceInterface
import com.rahul.pod.categories.network.CategoryServiceRepo
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito

class CategoryViewModelTest : BaseTest() {
    var viewModel: CategoryViewModel? = null

    override fun beforeEach() {
        super.beforeEach()
        viewModel = Mockito.mock(CategoryViewModel::class.java)

        Mockito.`when`(viewModel?.serviceRepo).thenReturn(
            Mockito.mock(CategoryServiceRepo::class.java)
        )

        Mockito.`when`(viewModel?.serviceRepo?.serviceAPIHelper).thenReturn(
            ServiceAPIHelper(
                CategoryServiceInterface::class.java, CategoryMockServiceImpl::class.java,
                ServiceType.MOCK, ""
            )
        )
    }

    @Test
    fun `get dashboard data on success`() {
        viewModel?.getCategoryData("Stories","All")
        Assert.assertNotNull(viewModel?.categoryData?.getOrAwaitValue())
        Assert.assertEquals(viewModel?.loader?.get(), false)

        Assert.assertEquals(
            viewModel?.categoryData?.value?.results?.get(0)?.title,
            "Dinosaur (2000) Score"
        )
        Assert.assertEquals(
            viewModel?.categoryData?.value?.results?.get(0)?.overview,
            "Many dinosaur films are animated and aimed more towards children, and Dinosaur is one of those films. It follows an orphaned dinosaur that is raised by lemurs. They join a herd of dinosaurs after a meteorite destroys their home."
        )
        Assert.assertEquals(
            viewModel?.categoryData?.value?.results?.get(0)?.id,
            "19401"
        )

    }
}