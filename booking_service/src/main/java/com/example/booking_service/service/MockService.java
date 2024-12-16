package com.example.booking_service.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;


import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Service
public class MockService {
    private Map<String, List<Map<String, Object>>> mockData;

    @PostConstruct
    public void loadMockData() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/mock-data.json");
            mockData = objectMapper.readValue(inputStream, new TypeReference<>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to load mock data", e);
        }
    }

    public Map<String, Object> getUserById(Long id) {
        return mockData.get("users").stream()
                .filter(user -> user.get("id").equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Map<String, Object> getShowtimeById(Long id) {
        return mockData.get("showtimes").stream()
                .filter(showtime -> showtime.get("id").equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Showtime not found"));
    }
}
