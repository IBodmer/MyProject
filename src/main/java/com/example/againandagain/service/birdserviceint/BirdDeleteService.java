package com.example.againandagain.service.birdserviceint;

import com.example.againandagain.exeptions.BirdNotFoundById;

public interface BirdDeleteService {
    String deleteBirdById(Long id) throws BirdNotFoundById;
}
