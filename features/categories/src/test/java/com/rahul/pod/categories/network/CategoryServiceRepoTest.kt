package com.rahul.pod.categories.network

import com.rahul.dino.core.BaseTest
import com.rahul.dino.core.network.ServiceAPIHelper
import com.rahul.dino.core.network.ServiceType
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito

class CategoryServiceRepoTest : BaseTest() {

    private var serviceRepo: CategoryServiceRepo? = null

    override fun beforeEach() {
        super.beforeEach()
        serviceRepo = Mockito.mock(CategoryServiceRepo::class.java)
        Mockito.`when`(serviceRepo?.serviceAPIHelper).thenReturn(
            ServiceAPIHelper(
                CategoryServiceInterface::class.java, CategoryMockServiceImpl::class.java,
                ServiceType.MOCK, ""
            )
        )
    }

    override fun afterEach() {
        super.afterEach()
    }

    @Test
    fun `get category data when success`() {
        serviceRepo?.getCategoryData("Stories","All",onSuccess = {
            Assert.assertTrue(it != null)
            Assert.assertEquals(it?.results[0].title, "Dinosaur (2000) Score")
            Assert.assertEquals(it?.results[0].overview, "Many dinosaur films are animated and aimed more towards children, and Dinosaur is one of those films. It follows an orphaned dinosaur that is raised by lemurs. They join a herd of dinosaurs after a meteorite destroys their home.")
            Assert.assertEquals(it?.results[0].id, "19401")
        }, onError = {
            assert(false)
        })
    }
}