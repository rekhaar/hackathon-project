package com.abc.app.mortgage.controller;

import com.abc.app.mortgage.dto.ABCError;
import com.abc.app.mortgage.dto.ABCResponse;
import com.abc.app.mortgage.handler.ABCCustomException;
import com.abc.app.mortgage.util.ABCResponseUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.abc.app.mortgage.controller")
@Log4j2
public class ABCExceptionHandler {

    @ExceptionHandler(ABCCustomException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ABCResponse> handleCustomException(ABCCustomException e) {
        ABCError err = new ABCError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        return ResponseEntity.internalServerError().body(ABCResponseUtil.error(err));
    }
}
