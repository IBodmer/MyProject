package com.example.againandagain.exeptions.notfound;

import jakarta.persistence.EntityNotFoundException;

public class NestNotFoundByName extends EntityNotFoundException {
    public NestNotFoundByName(String message) {
        super(message);
    }
}
