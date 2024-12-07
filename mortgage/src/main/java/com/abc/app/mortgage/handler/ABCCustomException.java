package com.abc.app.mortgage.handler;

public class ABCCustomException extends RuntimeException{
    public ABCCustomException() {
    }

    public ABCCustomException(String message) {
        super(message);
    }

    public ABCCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public ABCCustomException(Throwable cause) {
        super(cause);
    }

    public ABCCustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
