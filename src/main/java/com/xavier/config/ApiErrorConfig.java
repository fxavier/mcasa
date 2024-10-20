package com.xavier.config;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@ApplicationScoped
public class ApiErrorConfig {

    private Properties apiErrors;

    @PostConstruct
    public void init() {
        apiErrors = new Properties();
        try (InputStream inputStream = getClass().getResourceAsStream("/api_errors.properties")) {
            apiErrors.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load api_errors.properties", e);
        }
    }

    public String getErrorMessage(String key) {
        return apiErrors.getProperty(key);
    }
}