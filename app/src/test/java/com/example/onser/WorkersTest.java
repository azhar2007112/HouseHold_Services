package com.example.onser;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class WorkersTest {

    private workers worker;

    @Before
    public void setUp() {
        worker = new workers("John Doe", "1234567890", "Electrician");
        worker.setKey("test_key");
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", worker.getName());
    }

    @Test
    public void testSetName() {
        worker.setName("Jane Doe");
        assertEquals("Jane Doe", worker.getName());
    }

    @Test
    public void testGetPhone() {
        assertEquals("1234567890", worker.getPhone());
    }

    @Test
    public void testSetPhone() {
        worker.setPhone("9876543210");
        assertEquals("9876543210", worker.getPhone());
    }

    @Test
    public void testGetService() {
        assertEquals("Electrician", worker.getService());
    }

    @Test
    public void testSetService() {
        worker.setService("Plumber");
        assertEquals("Plumber", worker.getService());
    }

    @Test
    public void testGetKey() {
        assertEquals("test_key", worker.getKey());
    }

    @Test
    public void testSetKey() {
        worker.setKey("new_test_key");
        assertEquals("new_test_key", worker.getKey());
    }

    @Test
    public void testKeyInitiallyNull() {
        workers newWorker = new workers("New Worker", "5555555555", "Service");
        assertNull(newWorker.getKey());
    }
}
