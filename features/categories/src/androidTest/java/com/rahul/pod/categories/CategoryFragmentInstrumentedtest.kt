package com.rahul.pod.categories

import android.view.View
import androidx.annotation.NonNull
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rahul.dino.core.network.NetworkConfigInterface
import com.rahul.dino.navigation.mock.NetworkConfigMockImpl
import com.rahul.pod.categories.network.CategoryServiceRepo
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CategoryFragmentInstrumentedtest {
    @Before
    fun beforeEach() {
        loadModule()
    }

    @After
    fun afterEach() {
        stopKoin()
    }

    private fun loadModule() {
        startKoin {
            modules(
                module {
                    single<NetworkConfigInterface> { NetworkConfigMockImpl() }
                    factory { CategoryServiceRepo() }
                    viewModel { CategoryViewModel() }
                })
        }
    }


    @Test
    fun testCategoryFragment() {
        // Create a TestNavHostController
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext())

        // Create a graphical FragmentScenario for the TitleScreen
        val titleScenario = launchFragmentInContainer<CategoryFragment>()

        titleScenario.onFragment { fragment ->
            // Set the graph on the TestNavHostController
            navController.setGraph(R.navigation.nav_graph_category)

            // Make the NavController available via the findNavController() APIs
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        Thread.sleep(4000)

        Espresso.onView(ViewMatchers.withId(R.id.categoryRecyclerView))
            .check(
                ViewAssertions.matches(
                    atPosition(
                        0,
                        ViewMatchers.hasDescendant(ViewMatchers.withText("Great Wall of China"))
                    )
                )
            )


        Espresso.onView(ViewMatchers.withId(R.id.categoryRecyclerView))
            .check(
                ViewAssertions.matches(
                    atPosition(
                        0,
                        ViewMatchers.hasDescendant(ViewMatchers.withText("Great might be an understatement. One of the world’s largest building-construction projects, the Great Wall of China is widely thought to be about 5,500 miles (8,850 km) long; a disputed Chinese study, however, claims the length is 13,170 miles (21,200 km). Work began in the 7th century BCE and continued for two millennia. Although called a wall, the structure actually features two parallel walls for lengthy stretches. In addition, watchtowers and barracks dot the bulwark. One not-so-great thing about the wall, however, was its effectiveness. Although it was built to prevent invasions and raids, the wall largely failed to provide actual security. Instead, scholars have noted that it served more as political propaganda."))
                    )
                )
            )

    }

    private fun atPosition(position: Int, @NonNull itemMatcher: Matcher<View>): Matcher<View> {
        return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("has item at position $position: ")
                itemMatcher.describeTo(description)
            }

            override fun matchesSafely(view: RecyclerView): Boolean {
                val viewHolder = view.findViewHolderForAdapterPosition(position)
                    ?: // has no item on such position
                    return false
                return itemMatcher.matches(viewHolder.itemView)
            }
        }
    }

}