package xyz.flo.okcupidchallenge;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import xyz.flo.okcupidchallenge.view.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static xyz.flo.okcupidchallenge.TestUtils.withRecyclerView;

@RunWith(AndroidJUnit4.class)
public class RecyclerviewTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {
        MainActivity mActivity = activityTestRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    @Test
    public void checkRecyclerViews() {
        onView(withId(R.id.blendRecyclerView)).check(matches(isDisplayed()));
        onView(withId(R.id.matchViewPager)).perform(swipeLeft());
        onView(withId(R.id.topMatchRecyclerView)).check(matches(isDisplayed()));
    }

    @Test
    public void testTopMatchLike() {
        onView(withId(R.id.blendRecyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(10, ViewActions.click()));
        onView(withId(R.id.matchViewPager)).perform(swipeLeft());
        onView(withRecyclerView(R.id.topMatchRecyclerView).atPositionOnView(0, R.id.userImageView)).check(matches(isDisplayed()));
        onView(withRecyclerView(R.id.topMatchRecyclerView).atPositionOnView(0, R.id.userNameTextView)).check(matches(isDisplayed()));
    }
}
