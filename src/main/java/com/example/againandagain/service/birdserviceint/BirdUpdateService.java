package com.example.againandagain.service.birdserviceint;

import com.example.againandagain.DTO.request.BirdRequestUpdateDTO;
import com.example.againandagain.exeptions.BirdNotFoundById;

public interface BirdUpdateService {
    String updateBirdById (Long id, BirdRequestUpdateDTO birdRequestUpdateDTO) throws BirdNotFoundById;
}
