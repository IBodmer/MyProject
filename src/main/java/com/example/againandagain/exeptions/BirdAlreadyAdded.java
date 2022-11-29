package com.example.againandagain.exeptions;

public class BirdAlreadyAdded extends Exception{
    public BirdAlreadyAdded(String message) {
        super(message);
    }
}
