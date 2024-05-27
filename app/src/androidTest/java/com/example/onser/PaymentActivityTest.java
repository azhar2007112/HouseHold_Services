package com.example.onser;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class PaymentActivityTest {

    @Rule
    public ActivityScenarioRule<Payment> activityScenarioRule
            = new ActivityScenarioRule<>(Payment.class);

    @Test
    public void testPaymentMethods() {
        // Click on Cash on Delivery method
        onView(withId(R.id.cash_on_delivery_method)).perform(click());
        // Add assertions for expected behavior after clicking Cash on Delivery method

        // Click on bKash method


    }
}
