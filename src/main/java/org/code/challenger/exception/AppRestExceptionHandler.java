package org.code.challenger.exception;

import lombok.extern.slf4j.Slf4j;
import org.code.challenger.util.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class AppRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity appException(AppException appException) {
        log.error(appException.getMessage(), appException);
        return new ResponseEntity<>(appException.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity<>(AppConstants.EXCEPTION_GENERAL_ERROR, HttpStatus.I_AM_A_TEAPOT);
    }
}

