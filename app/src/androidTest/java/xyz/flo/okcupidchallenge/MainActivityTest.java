package xyz.flo.okcupidchallenge;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import xyz.flo.okcupidchallenge.view.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {
        MainActivity mActivity = activityTestRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    @Test
    public void checkViews() {
        onView(withId(R.id.tabLayout)).check(matches(isDisplayed()));
        onView(withId(R.id.matchViewPager)).check(matches(isDisplayed()));
    }

    @Test
    public void testViewPager() {
        onView(withId(R.id.matchViewPager)).perform(swipeLeft());
        onView(allOf(withText("Special Blend"), isDescendantOfA(withId(R.id.tabLayout))))
                .perform(click())
                .check(matches(isDisplayed()));
    }
}
