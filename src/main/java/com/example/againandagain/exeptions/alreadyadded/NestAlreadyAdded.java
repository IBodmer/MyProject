package com.example.againandagain.exeptions.alreadyadded;

import jakarta.persistence.EntityExistsException;

public class NestAlreadyAdded extends EntityExistsException {
    public NestAlreadyAdded(String message) {
        super(message);
    }
}
