package com.example.onser;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BookingClassTest {

    private BookingClass booking;

    @Before
    public void setUp() {
        // Initialize a BookingClass instance with sample data
        booking = new BookingClass("Cleaning", "123 Main St", "2024-05-25", "09:00 AM", "50");
        booking.setKey("abc123"); // Set key for testing
    }

    @Test
    public void testGetServices() {
        assertEquals("Cleaning", booking.getServices());
    }

    @Test
    public void testSetServices() {
        booking.setServices("Plumbing");
        assertEquals("Plumbing", booking.getServices());
    }

    @Test
    public void testGetAddress() {
        assertEquals("123 Main St", booking.getAddress());
    }

    @Test
    public void testSetAddress() {
        booking.setAddress("456 Elm St");
        assertEquals("456 Elm St", booking.getAddress());
    }

    @Test
    public void testGetDate() {
        assertEquals("2024-05-25", booking.getDate());
    }

    @Test
    public void testSetDate() {
        booking.setDate("2024-06-01");
        assertEquals("2024-06-01", booking.getDate());
    }

    @Test
    public void testGetTime() {
        assertEquals("09:00 AM", booking.getTime());
    }

    @Test
    public void testSetTime() {
        booking.setTime("02:30 PM");
        assertEquals("02:30 PM", booking.getTime());
    }

    @Test
    public void testGetCost() {
        assertEquals("50", booking.getCost());
    }

    @Test
    public void testSetCost() {
        booking.setCost("75");
        assertEquals("75", booking.getCost());
    }

    @Test
    public void testGetKey() {
        assertEquals("abc123", booking.getKey());
    }

    @Test
    public void testSetKey() {
        booking.setKey("xyz456");
        assertEquals("xyz456", booking.getKey());
    }
}
