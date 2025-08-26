package com.example.demo.common;

public enum ResultEnum implements IResult {
    SUCCESS(2001, "API call successful"),
    VALIDATE_FAILED(2002, "Validation failed"),
    COMMON_FAILED(2003, "API call failed"),
    FORBIDDEN(2004, "Forbidden");

    private final Integer code;
    private final String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() { return code; }

    @Override
    public String getMessage() { return message; }
}