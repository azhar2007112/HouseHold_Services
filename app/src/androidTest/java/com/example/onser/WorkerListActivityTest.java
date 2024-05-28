package com.example.onser;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@LargeTest
public class WorkerListActivityTest {

    @Rule
    public ActivityScenarioRule<WorkerList> activityScenarioRule
            = new ActivityScenarioRule<>(WorkerList.class);

    @Test
    public void recyclerViewDisplayed() {
        // Check if RecyclerView is displayed
        Espresso.onView(withId(R.id.worker_details))
                .check(matches(isDisplayed()));
    }

    @Test
    public void checkRecyclerViewItemCount() {
        // Replace with the expected number of items in your RecyclerView
        int expectedItemCount = 10;

        // Perform action and verify
        Espresso.onView(withId(R.id.worker_details))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .perform(RecyclerViewActions.scrollToPosition(expectedItemCount - 1));
    }
}
