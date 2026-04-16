package com.joaomdoamaral.tennis_booking_api.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class JwtServiceTest {

    private JwtService jwtService;

    @BeforeEach
    public void setup() {
        jwtService = new JwtService("my-super-secret-key-my-super-secret-key-123456", 86400000L);
    }

    @Test
    void shouldGenerateAndReadToken() {
        String token = jwtService.generateToken("joao@email.com", Map.of("role", "ROLE_ADMIN"));

        assertThat(token).isNotBlank();
        assertThat(jwtService.extractSubject(token)).isEqualTo("joao@email.com");
        assertThat(jwtService.isTokenValid(token)).isTrue();
    }
}
