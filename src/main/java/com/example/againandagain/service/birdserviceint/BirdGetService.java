package com.example.againandagain.service.birdserviceint;

import com.example.againandagain.DTO.response.BirdGetResponseDTO;
import com.example.againandagain.exeptions.BirdNotFoundById;

public interface BirdGetService {
    BirdGetResponseDTO getBirdById(Long id) throws BirdNotFoundById;
}
