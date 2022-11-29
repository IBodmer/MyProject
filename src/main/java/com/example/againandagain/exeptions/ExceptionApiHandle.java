package com.example.againandagain.exeptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionApiHandle {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorsList onMethodArgumentNotValidException(
            MethodArgumentNotValidException e
    ) {
        final List<ErrorMessages> violations = e.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorMessages(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        return new ErrorsList(violations);
    }


}

