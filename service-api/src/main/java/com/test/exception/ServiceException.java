package com.test.exception;

public class ServiceException extends RuntimeException {
    private Integer code;

    public ServiceException() {
    }

    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
