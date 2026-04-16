package com.joaomdoamaral.tennis_booking_api.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestSecurityController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "public ok";
    }

    @GetMapping("/protected")
    public String protectedEndpoint() {
        return "protected ok";
    }
}