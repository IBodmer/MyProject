package com.example.againandagain.exeptions.alreadyadded;

import jakarta.persistence.EntityExistsException;

public class BirdAlreadyAdded extends EntityExistsException {
    public BirdAlreadyAdded(String message) {
        super(message);
    }
}
