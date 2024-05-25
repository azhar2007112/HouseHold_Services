package com.example.onser;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class UpdateProfileActivityTest {

    @Rule
    public ActivityScenarioRule<UpdateProfile> activityScenarioRule
            = new ActivityScenarioRule<>(UpdateProfile.class);

    @Test
    public void testUpdateProfileComponents() {
        // Check if update_name EditText is displayed
        onView(withId(R.id.update_name)).check(matches(isDisplayed()));

        // Check if update_address EditText is displayed
        onView(withId(R.id.update_address)).check(matches(isDisplayed()));

        // Check if update_number EditText is displayed
        onView(withId(R.id.update_number)).check(matches(isDisplayed()));

        // Perform typeText actions on EditText fields as per your test scenario
        // For example:
        onView(withId(R.id.update_name)).perform(typeText("John Doe"));

        // Close the keyboard after typing text (if keyboard is shown)
        onView(withId(R.id.update_name)).perform(closeSoftKeyboard());

        // Click on update_info_button
        onView(withId(R.id.update_info_button)).perform(click());
        // Add assertions for expected behavior after clicking update_info_button
    }
}
