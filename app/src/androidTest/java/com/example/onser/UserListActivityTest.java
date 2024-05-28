package com.example.onser;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@LargeTest
public class UserListActivityTest {

    @Rule
    public ActivityScenarioRule<UserList> activityScenarioRule
            = new ActivityScenarioRule<>(UserList.class);

    @Before
    public void setUp() {
        // Launch the activity
        ActivityScenario.launch(UserList.class);
    }



    @Test
    public void testScrollRecyclerView() {
        // Perform scrolling action on RecyclerView
        Espresso.onView(withId(R.id.userlist))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .perform(RecyclerViewActions.scrollToPosition(5)); // Scroll to position 5, change as needed
    }

    @Test
    public void testCheckItemVisibility() {
        // Check visibility of specific items in RecyclerView
        int positionToCheck = 0; // Change this to the position of the item you want to check

        Espresso.onView(withId(R.id.userlist))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .perform(RecyclerViewActions.scrollToPosition(positionToCheck))
                .check(matches(isDisplayed()));
    }
}
