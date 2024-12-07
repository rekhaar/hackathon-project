package com.abc.app.mortgage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ABCResponse {
    @JsonProperty("abc_error") private ABCError abcError;

    public ABCResponse(ABCError abcError) {
        this.abcError = abcError;
    }

}
