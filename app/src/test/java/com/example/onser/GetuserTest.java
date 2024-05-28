package com.example.onser;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GetuserTest {

    private Getuser user;

    @Before
    public void setUp() {
        // Initialize a Getuser instance with sample data
        user = new Getuser("John Doe", "john.doe@example.com", "1234567890", "123 Main St");
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", user.getName());
    }

    @Test
    public void testSetName() {
        user.setName("Jane Smith");
        assertEquals("Jane Smith", user.getName());
    }

    @Test
    public void testGetEmail() {
        assertEquals("john.doe@example.com", user.getEmail());
    }

    @Test
    public void testSetEmail() {
        user.setEmail("jane.smith@example.com");
        assertEquals("jane.smith@example.com", user.getEmail());
    }

    @Test
    public void testGetPhonenumber() {
        assertEquals("1234567890", user.getPhonenumber());
    }

    @Test
    public void testSetPhonenumber() {
        user.setPhonenumber("9876543210");
        assertEquals("9876543210", user.getPhonenumber());
    }

    @Test
    public void testGetAddress() {
        assertEquals("123 Main St", user.getAddress());
    }

    @Test
    public void testSetAddress() {
        user.setAddress("456 Elm St");
        assertEquals("456 Elm St", user.getAddress());
    }
}
