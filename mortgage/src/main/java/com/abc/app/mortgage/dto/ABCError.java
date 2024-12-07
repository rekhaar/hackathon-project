package com.abc.app.mortgage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ABCError {

    @JsonProperty("status_code") private Integer statusCode;
    @JsonProperty("message") private String message;

    public ABCError(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

}
