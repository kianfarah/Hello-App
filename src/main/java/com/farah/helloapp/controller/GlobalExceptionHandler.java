package com.farah.helloapp.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<?> handleUserNotFoundException(final UserNotFoundException e) {
    final var error =
        new ErrorResponse(
            LocalDateTime.now(),
            HttpStatus.NOT_FOUND.value(),
            "Resource not found",
            e.getMessage(),
            null);
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<ErrorResponse> handleInvalidArgument(
      final MethodArgumentTypeMismatchException e) {
    final var error =
        new ErrorResponse(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            "Invalid argument",
            e.getMessage(),
            null);
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleValidation(final MethodArgumentNotValidException e) {
    var errors = new HashMap<String, String>();
    e.getBindingResult()
        .getFieldErrors()
        .forEach(
            (fieldError) -> {
              errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            });
    final var error =
        new ErrorResponse(
            LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Validation Failed", "", errors);

    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleGeneralException(final Exception e) {
    var error =
        new ErrorResponse(
            LocalDateTime.now(),
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Internal server error",
            e.getMessage(),
            null);
    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
