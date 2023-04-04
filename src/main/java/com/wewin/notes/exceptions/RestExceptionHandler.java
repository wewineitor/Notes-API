package com.wewin.notes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class RestExceptionHandler {

    ErrorDetail fillErrorData(int code, String message) {
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setCode(code);
        errorDetail.setMessage(message);
        return errorDetail;
    }
    @ExceptionHandler(IllegalArgumentException.class)
    ErrorDetail handleIllegalArgumentException() {
        return fillErrorData(HttpStatus.BAD_REQUEST.value(), "The user you are trying to modify does not exist");
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    ErrorDetail handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException exception) {
        return fillErrorData(exception.getErrorCode(), "Email already taken");
    }
}
