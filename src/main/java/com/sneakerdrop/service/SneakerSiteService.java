package com.sneakerdrop.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SneakerSiteService {

    private final RestTemplate restTemplate;

    public SneakerSiteService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<String> getSites(){

        return null;
    }


    public String getNikeData() {
        String url = "https://api.nike.com/149e9513-01fa-4fb0-aad4-566afd725d1b/2d206a39-8ed7-437e-a3be-862e0f06eea3/fp?x-kpsdk-v=j-0.0.0";
        return restTemplate.getForObject(url, String.class);
    }
}

