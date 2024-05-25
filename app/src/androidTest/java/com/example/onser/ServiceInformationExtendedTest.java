package com.example.onser;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.junit.Before;
import org.junit.Test;

public class ServiceInformationExtendedTest {

    @Before
    public void launchActivity() {
        // Launch the activity before each test
        ActivityScenario.launch(Service_information_extended.class);
    }

    @Test
    public void checkImageViewDisplayed() {
        // Check if the ImageView with id ser_img is displayed
        Espresso.onView(ViewMatchers.withId(R.id.ser_img))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }



    @Test
    public void clickProceedToBookButton() {
        // Perform click on the Proceed to book button and verify activity transition
        Espresso.onView(ViewMatchers.withId(R.id.proceed_to_book))
                .perform(ViewActions.click());


    }

    // Add more tests as needed for other UI components and interactions
}
