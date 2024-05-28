package com.example.onser;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
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
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityEspressoTest {

    // This rule launches the activity under test before each test method annotated with @Test
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testAppnameTextViewVisible() {
        // Check if appname TextView is visible
        onView(withId(R.id.appname)).check(matches(isDisplayed()));
    }

    @Test
    public void testEmailEditTextVisible() {
        // Check if email EditText is visible
        onView(withId(R.id.email)).check(matches(isDisplayed()));
    }

    @Test
    public void testLoginButtonVisible() {
        // Check if login Button is visible
        onView(withId(R.id.login)).check(matches(isDisplayed()));
    }

    @Test
    public void testLoginButtonFunctionality() {
        // Enter valid email and password, then click login button
        onView(withId(R.id.email)).perform(typeText("test@example.com"), closeSoftKeyboard());
        onView(withId(R.id.loginpass)).perform(typeText("password123"), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());

        // Add assertions for login success or expected behavior
        // Example: Check if a new activity is launched or a toast is displayed
        // onView(withText("Welcome!")).inRoot(withDecorView(not(activity.getWindow().getDecorView()))).check(matches(isDisplayed()));
    }
}
