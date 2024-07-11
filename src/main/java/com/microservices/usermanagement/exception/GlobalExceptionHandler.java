package com.microservices.usermanagement.exception;

import com.microservices.usermanagement.dto.ErrorResponseDTO;
import com.microservices.usermanagement.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger LOGGER = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ErrorResponseDTO> handleCustomerAlreadyFoundException(UserAlreadyExistException ex, WebRequest request) {
        LOGGER.error(ex);
        ErrorResponseDTO error = ErrorResponseDTO.builder()
                .path(request.getDescription(false))
                .systemErrorCode(Constants.SystemErrorCode.USER_ALREADY_EXISTS_EXCEPTION_ERROR_CODE)
                .typeId(ex.getTypeId())
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(Exception ex, WebRequest request) {
        LOGGER.error(ex);
        ErrorResponseDTO error = ErrorResponseDTO.builder()
                .path(request.getDescription(false))
                .systemErrorCode(Constants.SystemErrorCode.SYSTEM_EXCEPTION_ERROR_CODE)
                .typeId(Constants.TypeErrorCode.TECHNICAL_ERROR_TYPE_ID)
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp, WebRequest request) {
        LOGGER.error(exp);
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .path(request.getDescription(false))
                .systemErrorCode(Constants.SystemErrorCode.ILLEGAL_METHOD_ARGUMENTS_EXCEPTION_ERROR_CODE)
                .typeId(Constants.TypeErrorCode.INVALID_METHOD_ARGUMENTS)
                .errors(errors)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(errorResponseDTO);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponseDTO> handleBadCredentialsException(BadCredentialsException ex, WebRequest request) {
        LOGGER.error(ex);
        ErrorResponseDTO error = ErrorResponseDTO.builder()
                .path(request.getDescription(false))
                .systemErrorCode(Constants.SystemErrorCode.SYSTEM_EXCEPTION_ERROR_CODE)
                .typeId(Constants.TypeErrorCode.BAD_CREDNETIALS_TYPE_ID)
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
