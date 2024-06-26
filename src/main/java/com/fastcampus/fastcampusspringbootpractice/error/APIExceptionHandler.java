package com.fastcampus.fastcampusspringbootpractice.error;

import com.fastcampus.fastcampusspringbootpractice.constant.ErrorCode;
import com.fastcampus.fastcampusspringbootpractice.dto.APIErrorResponse;
import com.fastcampus.fastcampusspringbootpractice.exception.GeneralException;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@RestControllerAdvice(annotations = RestController.class)
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> general(GeneralException e,  WebRequest request) {
        ErrorCode errorCode = e.getErrorCode();
        HttpStatus status = errorCode.isClientError() ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR;

        return super.handleExceptionInternal(
                e,
                APIErrorResponse.of(false, errorCode, errorCode.getMessage(e)),
                HttpHeaders.EMPTY,
                status,
                request);

//        return ResponseEntity
//                .status(status)
//                .body(APIErrorResponse.of(false, errorCode, errorCode.getMessage(e)));
    }

    @ExceptionHandler
    public ResponseEntity<Object> exception(Exception e, WebRequest request) {

        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        return super.handleExceptionInternal(
                e,
                APIErrorResponse.of(false, errorCode, errorCode.getMessage(e)),
                HttpHeaders.EMPTY,
                status,
                request);

//        return ResponseEntity
//                .status(status)
//                .body(APIErrorResponse.of(false, errorCode, errorCode.getMessage(e)));

    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        ErrorCode errorCode = statusCode.is4xxClientError() ? ErrorCode.SPRING_BAD_REQUEST: ErrorCode.SPRING_INTERNAL_SERVER_ERROR;

        return super.handleExceptionInternal(ex,
                APIErrorResponse.of(false, errorCode, errorCode.getMessage(ex)),
                headers,
                statusCode,
                request);


    }
}

