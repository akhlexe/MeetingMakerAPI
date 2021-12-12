package com.exepinero.MeetingMakerAPI.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public class ErrorDetails {

    private LocalDate date;
    private String message;
    private String description;

    public ErrorDetails(String message, String description) {
        this.date = LocalDate.now();
        this.message = message;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
