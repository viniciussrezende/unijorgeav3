package com.projetomonitoramente.unijorgeav3.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ErrorResponse {
    private String message;
    private String details;
    private LocalDateTime timestamp;

    private Map<String, String> mapError;

    public ErrorResponse(String message, String details) {
        this.message = message;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, String> getMapError() {
        return mapError;
    }

    public void setMapError(Map<String, String> mapError) {
        this.mapError = mapError;
    }
}
