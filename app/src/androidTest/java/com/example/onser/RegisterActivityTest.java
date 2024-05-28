package com.example.onser;

import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
public class RegisterActivityTest {

    @Rule
    public ActivityScenarioRule<Register> activityScenarioRule
            = new ActivityScenarioRule<>(Register.class);

    @Test
    public void testRegisterButton() {
        // Check if Register button is displayed and clickable
        Espresso.onView(withId(R.id.register2))
                .check(ViewAssertions.matches(isDisplayed()))
                .perform(ViewActions.click());
    }

    @Test
    public void testBackButton() {
        // Check if Back button is displayed and clickable
        Espresso.onView(withId(R.id.backspace_reg))
                .check(ViewAssertions.matches(isDisplayed()))
                .perform(ViewActions.click());

        // Verify if MainActivity is launched after clicking Back button
        Espresso.onView(withId(R.id.login))
                .check(ViewAssertions.matches(isDisplayed()));
    }

    @Test
    public void testInvalidRegistration() {
        // Attempt registration without filling any fields
        Espresso.onView(withId(R.id.register2))
                .perform(ViewActions.click());


    }

    // Custom Matcher for checking error text


}
