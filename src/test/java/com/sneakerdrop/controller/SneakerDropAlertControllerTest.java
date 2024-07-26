package com.sneakerdrop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SneakerDropAlertControllerTest {
    private SneakerDropAlertController sneakerDropAlertController = new SneakerDropAlertController();

    @Test
    void getSites() {
        ResponseEntity<List<String>> test = sneakerDropAlertController.getSites();
        assertNull(test, "This is null");
    }

    @Test
    void register() {
        String siteCode = "site1";
        String emailAddress = "test@example.com";
        ResponseEntity<String> response = sneakerDropAlertController.register(siteCode, emailAddress);

        String expectedMessage = "Registration successful for site: " + siteCode + " with email: " + emailAddress;
        assertEquals(expectedMessage, response.getBody(), "Response body should match the expected registration message");
    }

    @Test
    void unsubscribe() {
        String siteCode = "site1";
        String emailAddress = "test@example.com";

        ResponseEntity<String> response = sneakerDropAlertController.unsubscribe(siteCode, emailAddress);

        String expectedMessage = "hello unsubscribe";
        assertEquals(expectedMessage, response.getBody(), "Response body should match the expected unsubscribe message");
    }
}