package com.rahul.pod.dashboard

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
import com.rahul.dino.core.ui.CommonAppBar
import com.rahul.dino.navigation.mock.NetworkConfigMockImpl
import com.rahul.pod.dashboard.network.DashboardServiceRepo
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
class DashboardFragmentInstrumentedTest {
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
                    factory { DashboardServiceRepo() }
                    viewModel { DashboardViewModel() }
                })
        }
    }


    @Test
    fun testDashBoardFragment() {
        // Create a TestNavHostController
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext())

        // Create a graphical FragmentScenario for the TitleScreen
        val titleScenario = launchFragmentInContainer<DashboardFragment>()

        titleScenario.onFragment { fragment ->
            // Set the graph on the TestNavHostController
            navController.setGraph(R.navigation.nav_graph_dashboard)

            // Make the NavController available via the findNavController() APIs
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        Thread.sleep(4000)

        Espresso.onView(ViewMatchers.withId(R.id.dashboardRecyclerView))
            .check(
                ViewAssertions.matches(
                    atPosition(
                        0,
                        ViewMatchers.hasDescendant(ViewMatchers.withText("Stories"))
                    )
                )
            )


        Espresso.onView(ViewMatchers.withId(R.id.dashboardRecyclerView))
            .check(
                ViewAssertions.matches(
                    atPosition(
                        0,
                        ViewMatchers.hasDescendant(ViewMatchers.withText("All"))
                    )
                )
            )

        Espresso.onView(ViewMatchers.withId(R.id.dashboardRecyclerView))
            .check(
                ViewAssertions.matches(
                    atPosition(
                        0,
                        ViewMatchers.hasDescendant(ViewMatchers.withText("Kids"))
                    )
                )
            )

        Espresso.onView(ViewMatchers.withId(R.id.dashboardRecyclerView))
            .check(
                ViewAssertions.matches(
                    atPosition(
                        1,
                        ViewMatchers.hasDescendant(ViewMatchers.withText("Videos"))
                    )
                )
            )

        Espresso.onView(ViewMatchers.withId(R.id.dashboardRecyclerView))
            .check(
                ViewAssertions.matches(
                    atPosition(
                        2,
                        ViewMatchers.hasDescendant(ViewMatchers.withText("Market"))
                    )
                )
            )


        Thread.sleep(3000)


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