package com.example.againandagain.service.birdserviceint;

import com.example.againandagain.DTO.request.BirdRequestAddDTO;
import com.example.againandagain.DTO.request.BirdRequestUpdateDTO;
import com.example.againandagain.DTO.response.BirdResponseDTO;
import com.example.againandagain.exeptions.alreadyadded.BirdAlreadyAdded;
import com.example.againandagain.exeptions.notfound.BirdNotFoundById;
import com.example.againandagain.exeptions.notfound.NestNotFoundById;

public interface BirdService {
    BirdResponseDTO addBird(BirdRequestAddDTO bird) throws NestNotFoundById, BirdAlreadyAdded;
    BirdResponseDTO deleteBirdById(Long id) throws BirdNotFoundById;
    BirdResponseDTO getBirdById(Long id) throws BirdNotFoundById;
    BirdResponseDTO updateBirdById (Long id, BirdRequestUpdateDTO birdRequestUpdateDTO) throws BirdNotFoundById;
}
