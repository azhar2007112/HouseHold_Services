package com.example.onser;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

public class fbTest {

    @Test
    public void testConstructorAndGetFeedback() {
        // Arrange
        String feedbackText = "Great app!";

        // Act
        fb feedbackObject = new fb(feedbackText);
        String retrievedFeedback = feedbackObject.getFeedback();

        // Assert
        assertEquals(feedbackText, retrievedFeedback);
    }
}
