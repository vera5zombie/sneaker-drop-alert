package com.sneakerdrop.controller;

import com.sneakerdrop.service.NikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/sneakerdropalert")
public class SneakerDropAlertController {

    private NikeService nikeService;

    @GetMapping("hello")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/get-nike-data")
    public ResponseEntity<String> getSites() {
        String s = nikeService.getNikeData();
        return ResponseEntity.ok(s);
    }

    @PostMapping("/registration/{site_code}")
    public ResponseEntity<String> register(@PathVariable String site_code, @RequestParam String email_address) {
        return ResponseEntity.ok("Registration successful for site: " + site_code + " with email: " + email_address);
    }

    @PostMapping("/unsubscribe/{site_code}")
    public ResponseEntity<String> unsubscribe(@PathVariable String site_code, @RequestParam String email_address) {
        return ResponseEntity.ok("hello unsubscribe");
    }


}

