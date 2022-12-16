package com.example.againandagain.exeptions;

import com.example.againandagain.exeptions.alreadyadded.BirdAlreadyAdded;
import com.example.againandagain.exeptions.alreadyadded.NestAlreadyAdded;
import com.example.againandagain.exeptions.notfound.BirdNotFoundById;
import com.example.againandagain.exeptions.notfound.NestNotFoundById;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionApiHandle {
    @ExceptionHandler({BirdNotFoundById.class, NestNotFoundById.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiError> handleNotFoundException(EntityNotFoundException e, WebRequest webRequest) {
        return handleExceptionInternal(e, new ApiError(e.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND, webRequest);
    }

    @ExceptionHandler({BirdAlreadyAdded.class, NestAlreadyAdded.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ApiError> handleAlreadyAddedException(EntityExistsException e, WebRequest webRequest) {
        return handleExceptionInternal(e, new ApiError(e.getMessage(), HttpStatus.CONFLICT, LocalDateTime.now()), HttpStatus.CONFLICT, webRequest);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ApiValidError> onConstraintValidationException(
            ConstraintViolationException e
    ) {
         List<ApiValidError> api = e.getConstraintViolations().stream()
                .map(
                        violation -> new ApiValidError(
                                violation.getPropertyPath().toString(),
                                violation.getMessage(),
                                HttpStatus.BAD_REQUEST,
                                LocalDateTime.now()
                        )
                )
                .collect(Collectors.toList());
        return api;

    }


    protected ResponseEntity<ApiError> handleExceptionInternal(Exception ex, ApiError apiError, HttpStatus status, WebRequest webRequest) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            webRequest.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        return new ResponseEntity<>(apiError, status);
    }
}

