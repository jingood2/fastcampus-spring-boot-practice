package com.fastcampus.fastcampusspringbootpractice.error;

import com.fastcampus.fastcampusspringbootpractice.constant.ErrorCode;
import com.fastcampus.fastcampusspringbootpractice.dto.APIErrorResponse;
import com.fastcampus.fastcampusspringbootpractice.exception.GeneralException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler
    public ModelAndView general(GeneralException e) {

        ErrorCode errorCode = e.getErrorCode();
        HttpStatus status = errorCode.isClientError() ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR;

        return new ModelAndView(
                "error",
                Map.of(
                        "statusCode", status.value(),
                        "errorCode", errorCode,
                        "message",  errorCode.getMessage(status.getReasonPhrase())
                ),
                status
        );
    }

    @ExceptionHandler
    public ModelAndView exception(Exception e) {
        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        return new ModelAndView(
                "error",
                Map.of(
                        "statusCode", status.value(),
                        "errorCode", errorCode,
                        "message",  errorCode.getMessage(status.getReasonPhrase())
                ),
                status
        );
    }
}

