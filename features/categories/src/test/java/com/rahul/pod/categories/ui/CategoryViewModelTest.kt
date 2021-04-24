package com.rahul.pod.categories.ui

import com.rahul.dino.core.utils.getOrAwaitValue
import com.rahul.pod.categories.CategoryBaseTest
import com.rahul.pod.categories.CategoryViewModel
import org.junit.Assert
import org.junit.Test

class CategoryViewModelTest : CategoryBaseTest() {
    var viewModel: CategoryViewModel? = null


    override fun beforeEach() {
        super.beforeEach()
        viewModel = CategoryViewModel()
    }


    @Test
    fun `get dashboard data on success`() {
        viewModel?.getCategoryData("Stories", "All").toString().apply {
            Assert.assertNotNull(viewModel?.categoryData?.getOrAwaitValue())
            Assert.assertEquals(viewModel?.loader?.get(), false)

            Assert.assertEquals(
                viewModel?.categoryData?.value?.results?.get(0)?.title,
                "Great Wall of China"
            )
            Assert.assertEquals(
                viewModel?.categoryData?.value?.results?.get(0)?.overview,
                "Great might be an understatement. One of the world’s largest building-construction projects, the Great Wall of China is widely thought to be about 5,500 miles (8,850 km) long; a disputed Chinese study, however, claims the length is 13,170 miles (21,200 km). Work began in the 7th century BCE and continued for two millennia. Although called a wall, the structure actually features two parallel walls for lengthy stretches. In addition, watchtowers and barracks dot the bulwark. One not-so-great thing about the wall, however, was its effectiveness. Although it was built to prevent invasions and raids, the wall largely failed to provide actual security. Instead, scholars have noted that it served more as political propaganda."            )
            Assert.assertEquals(
                viewModel?.categoryData?.value?.results?.get(0)?.id,
                19401
            )
        }

    }
}