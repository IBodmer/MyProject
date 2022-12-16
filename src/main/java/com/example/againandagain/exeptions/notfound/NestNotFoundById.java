package com.example.againandagain.exeptions.notfound;

import jakarta.persistence.EntityNotFoundException;

public class NestNotFoundById extends EntityNotFoundException {
    public NestNotFoundById(String message) {
        super(message);
    }
}
