package com.rahul.pod.login

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rahul.dino.core.network.NetworkConfigInterface
import com.rahul.dino.navigation.mock.NetworkConfigMockImpl
import com.rahul.pod.login.network.LoginServiceRepo
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
class LoginFragmentInstrumentedTest {
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
                    factory { LoginServiceRepo() }
                    viewModel { LoginViewModel() }
                })
        }
    }


    @Test
    fun testLoginFragment() {
        // Create a TestNavHostController
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext())

        // Create a graphical FragmentScenario for the TitleScreen
        val titleScenario = launchFragmentInContainer<LoginFragment>()

        titleScenario.onFragment { fragment ->
            // Set the graph on the TestNavHostController
            navController.setGraph(R.navigation.nav_graph_login)

            // Make the NavController available via the findNavController() APIs
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        Espresso.onView(ViewMatchers.withId(R.id.userName))
            .check(ViewAssertions.matches(ViewMatchers.withHint("UserName")))
        Espresso.onView(ViewMatchers.withId(R.id.password))
            .check(ViewAssertions.matches(ViewMatchers.withHint("Password")))
        Espresso.onView(ViewMatchers.withId(R.id.loginButton))
            .check(ViewAssertions.matches(ViewMatchers.withText("SUBMIT")))

        Thread.sleep(1500)

        Espresso.onView(ViewMatchers.withId(R.id.userName))
            .perform(ViewActions.clearText(), ViewActions.typeText("Sample"))
        hideKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.password))
            .perform(ViewActions.clearText(), ViewActions.typeText("Sample"))
        hideKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.loginButton)).perform(ViewActions.click())

        Thread.sleep(1500)
    }

    private fun hideKeyboard() {
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard())
    }

}