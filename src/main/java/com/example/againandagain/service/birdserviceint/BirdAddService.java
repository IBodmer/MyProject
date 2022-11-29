package com.example.againandagain.service.birdserviceint;

import com.example.againandagain.DTO.request.BirdRequestAddDTO;
import com.example.againandagain.exeptions.BirdAlreadyAdded;
import com.example.againandagain.exeptions.NestIdNotFound;

public interface BirdAddService {
    String addBird(BirdRequestAddDTO bird) throws NestIdNotFound, BirdAlreadyAdded;
}
