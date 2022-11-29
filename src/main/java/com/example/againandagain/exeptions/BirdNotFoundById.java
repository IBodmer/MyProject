package com.example.againandagain.exeptions;

public class BirdNotFoundById extends Exception {
    public BirdNotFoundById(String message) {
        super(message);
    }
}
