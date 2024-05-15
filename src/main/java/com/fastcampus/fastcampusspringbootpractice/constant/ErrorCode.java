package com.fastcampus.fastcampusspringbootpractice.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.function.Predicate;


@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    OK(0, ErrorCategory.NORMAL, "Ok"),

    BAD_REQUEST( 10000, ErrorCategory.CLIENT, "Bad Request"),
    SPRING_BAD_REQUEST( 10001, ErrorCategory.CLIENT, "Spring-detected Bad Request"),

    INTERNAL_SERVER_ERROR( 20000, ErrorCategory.SERVER, "Internal Server Error"),
    SPRING_INTERNAL_SERVER_ERROR( 200001, ErrorCategory.SERVER,  "Spring-detected Internal Server Error"),
    ;

    private final int code;
    private final ErrorCategory category;
    private final String message;

    public String getMessage(Exception e) {
        return getMessage(e.getMessage());
    }

    public String getMessage(String message) {
        return Optional.ofNullable(message)
                .filter(Predicate.not(String::isBlank))
                .orElse(getMessage());
    }

    public boolean isClientError() {
        return ErrorCategory.CLIENT == this.category;
    }

    public boolean isServerError() {
        return ErrorCategory.SERVER == this.category;
    }

    public String toString() {
        return String.format("%s %s %s", this.getCode(), this.getCategory(), this.getMessage());
    }

    public enum ErrorCategory {
        CLIENT,
        SERVER,
        NORMAL
    }
}
