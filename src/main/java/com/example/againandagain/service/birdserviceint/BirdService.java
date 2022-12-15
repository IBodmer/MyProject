package com.example.againandagain.service.birdserviceint;

import com.example.againandagain.DTO.request.BirdRequestAddDTO;
import com.example.againandagain.DTO.request.BirdRequestUpdateDTO;
import com.example.againandagain.DTO.response.BirdGetResponseDTO;
import com.example.againandagain.exeptions.BirdAlreadyAdded;
import com.example.againandagain.exeptions.BirdNotFoundById;
import com.example.againandagain.exeptions.NestIdNotFound;

public interface BirdService {
    String addBird(BirdRequestAddDTO bird) throws NestIdNotFound, BirdAlreadyAdded;
    String deleteBirdById(Long id) throws BirdNotFoundById;
    BirdGetResponseDTO getBirdById(Long id) throws BirdNotFoundById;
    String updateBirdById (Long id, BirdRequestUpdateDTO birdRequestUpdateDTO) throws BirdNotFoundById;
}
