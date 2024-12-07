package com.abc.app.mortgage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.abc.app.mortgage.util.ResponseError;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseError> getUsernotFoundExceptionHandler(UserNotFoundException exp, WebRequest req){
		ResponseError error=new ResponseError();
		error.setCode("3000");
		error.setMsg(exp.getMessage());
		return new ResponseEntity<ResponseError>(error,HttpStatus.NO_CONTENT);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseError> getExceptionHandler(Exception exp, WebRequest req){
		ResponseError error=new ResponseError();
		error.setCode("3500");
		error.setMsg(exp.getMessage());
		return new ResponseEntity<ResponseError>(error,HttpStatus.BAD_REQUEST);
	}
}
