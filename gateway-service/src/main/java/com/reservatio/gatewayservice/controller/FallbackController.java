package com.reservatio.gatewayservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/global-fallback")
public class FallbackController {
   @GetMapping
    public String fallback() {

     return "Service is down. Please try again later.";
    }
}