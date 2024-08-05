package com.sneakerdrop.controller;


import com.sneakerdrop.service.SneakerSiteService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SneakerDropAlertController.class)
class SneakerDropAlertControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SneakerSiteService sneakerSiteService;

    @Autowired
    private SneakerDropAlertController sneakerDropAlertController;
    @Test
    void getSites() throws Exception{
        List<String> sites = Arrays.asList("Site1", "Site2", "Site3");
        given(sneakerSiteService.getSites()).willReturn(sites);

        mockMvc.perform(get("/v1/sneakerdropalert/sites")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[\"Site1\",\"Site2\",\"Site3\"]"));
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