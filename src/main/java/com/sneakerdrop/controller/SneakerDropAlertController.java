package com.sneakerdrop.controller;

import com.sneakerdrop.service.SneakerSiteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/sneakerdropalert")
public class SneakerDropAlertController {

    private SneakerSiteService sneakerSiteService;

    @GetMapping("/sites")
    public ResponseEntity<List<String>> getSites() {
        List<String> s = sneakerSiteService.getSites();
        return ResponseEntity.ok(s);
    }

    @PostMapping("/registration/{site_code}")
    public ResponseEntity<String> register(@PathVariable String site_code, @RequestParam String email_address) {
        return ResponseEntity.ok("Registration successful for site: " + site_code + " with email: " + email_address);
    }

    @PostMapping("/unsubscription/{site_code}")
    public ResponseEntity<String> unsubscribe(@PathVariable String site_code, @RequestParam String email_address) {
        return ResponseEntity.ok("hello unsubscribe");
    }

}

