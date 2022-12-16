package com.example.againandagain.exeptions.notfound;

import jakarta.persistence.EntityNotFoundException;

public class BirdNotFoundById extends EntityNotFoundException {
    public BirdNotFoundById(String message) {
        super(message);
    }
}
