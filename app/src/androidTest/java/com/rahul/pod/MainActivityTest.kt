package com.rahul.pod


import android.view.View
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loginTest() {
        val textView = onView(
            allOf(
                withId(R.id.dino_logo_text), withText("Dino App"),
                withParent(withParent(withId(R.id.nav_host_fragment))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Dino App")))

        val textView2 = onView(
            allOf(
                withText("Login"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Login")))

        onView(withId(R.id.userName)).check(matches(withHint("UserName")))
        onView(withId(R.id.password)).check(matches(withHint("Password")))
        onView(withId(R.id.loginButton)).check(matches(withText("SUBMIT")))

        Thread.sleep(1500)

        onView(withId(R.id.userName))
        .perform(clearText(), typeText("Sample"))

        onView(withId(R.id.password))
            .perform(clearText(), typeText("Sample"))
        hideKeyboard()

        onView(withId(R.id.loginButton)).perform(click())

        Thread.sleep(1500)

    }

    @Test
    fun dashboardTest() {
        Thread.sleep(1500)

        onView(withId(R.id.userName))
            .perform(clearText(), typeText("Sample"))

        onView(withId(R.id.password))
            .perform(clearText(), typeText("Sample"))
        hideKeyboard()

        onView(withId(R.id.loginButton)).perform(click())

        Thread.sleep(1500)

        Thread.sleep(4000)

        onView(withId(R.id.dashboardRecyclerView))
            .check(matches(atPosition(0, hasDescendant(withText("Stories")))))


        onView(withId(R.id.dashboardRecyclerView))
            .check(matches(atPosition(0, hasDescendant(withText("All")))))

        onView(withId(R.id.dashboardRecyclerView))
            .check(matches(atPosition(0, hasDescendant(withText("Kids")))))

        onView(withId(R.id.dashboardRecyclerView))
            .check(matches(atPosition(1, hasDescendant(withText("Videos")))))

        onView(withId(R.id.dashboardRecyclerView))
            .check(matches(atPosition(2, hasDescendant(withText("Market")))))

        onView(withId(R.id.dashboardRecyclerView))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )


        Thread.sleep(3000)

    }

    @Test
    fun categoryTest() {
        Thread.sleep(1500)

        onView(withId(R.id.userName))
            .perform(clearText(), typeText("Sample"))

        onView(withId(R.id.password))
            .perform(clearText(), typeText("Sample"))
        hideKeyboard()

        onView(withId(R.id.loginButton)).perform(click())

        Thread.sleep(1500)

        Thread.sleep(4000)

        onView(withId(R.id.dashboardRecyclerView))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )


        Thread.sleep(3000)

        onView(withId(R.id.categoryRecyclerView))
            .check(matches(atPosition(0, hasDescendant(withText("Great Wall of China")))))


        onView(withId(R.id.categoryRecyclerView))
            .check(matches(atPosition(0, hasDescendant(withText("Great might be an understatement. One of the world’s largest building-construction projects, the Great Wall of China is widely thought to be about 5,500 miles (8,850 km) long; a disputed Chinese study, however, claims the length is 13,170 miles (21,200 km). Work began in the 7th century BCE and continued for two millennia. Although called a wall, the structure actually features two parallel walls for lengthy stretches. In addition, watchtowers and barracks dot the bulwark. One not-so-great thing about the wall, however, was its effectiveness. Although it was built to prevent invasions and raids, the wall largely failed to provide actual security. Instead, scholars have noted that it served more as political propaganda.")))))

        Thread.sleep(3000)

        onView(withId(R.id.categoryRecyclerView))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(4))


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

    fun clickChildViewWithId(id: Int): ViewAction? {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View>? {
                return null
            }

            override fun getDescription(): String {
                return "Click on a child view with specified id."
            }

            override fun perform(uiController: UiController, view: View) {
                val v = view.findViewById<View>(id)
                v.performClick()
            }
        }
    }

    private fun hideKeyboard() {
        onView(isRoot()).perform(closeSoftKeyboard())
    }
}
