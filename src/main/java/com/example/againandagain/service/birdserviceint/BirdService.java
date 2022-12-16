package com.example.againandagain.service.birdserviceint;

import com.example.againandagain.DTO.request.BirdRequestAddDTO;
import com.example.againandagain.DTO.request.BirdRequestUpdateDTO;
import com.example.againandagain.DTO.response.BirdGetResponseDTO;
import com.example.againandagain.DTO.response.BirdResponseDTO;
import com.example.againandagain.exeptions.BirdAlreadyAdded;
import com.example.againandagain.exeptions.BirdNotFoundById;
import com.example.againandagain.exeptions.NestNotFoundById;

public interface BirdService {
    BirdResponseDTO addBird(BirdRequestAddDTO bird) throws NestNotFoundById, BirdAlreadyAdded;
    void deleteBirdById(Long id) throws BirdNotFoundById;
    BirdGetResponseDTO getBirdById(Long id) throws BirdNotFoundById;
    BirdResponseDTO updateBirdById (Long id, BirdRequestUpdateDTO birdRequestUpdateDTO) throws BirdNotFoundById;
}
