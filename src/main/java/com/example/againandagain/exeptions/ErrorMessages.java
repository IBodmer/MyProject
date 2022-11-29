package com.example.againandagain.exeptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessages {
    private final String fieldName;
    private final String message;

    public ErrorMessages(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
}
