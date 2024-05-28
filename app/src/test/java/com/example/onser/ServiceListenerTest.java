package com.example.onser;

import junit.framework.TestCase;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ServiceListenerTest {

    // Create a simple implementation of ServiceListener for testing
    private static class TestServiceListener implements ServiceListener {
        int clickedPosition = -1;

        @Override
        public void onItemClicked(int position) {
            clickedPosition = position;
        }
    }

    @Test
    public void testOnItemClicked() {
        // Create an instance of your TestServiceListener
        TestServiceListener listener = new TestServiceListener();

        // Call the method under test
        listener.onItemClicked(5); // Example position

        // Assert that the clickedPosition was set correctly
        assertEquals(5, listener.clickedPosition);
    }
}
