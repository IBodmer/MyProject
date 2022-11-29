package com.example.againandagain.service.nestserviceint;

import com.example.againandagain.DTO.response.NestResponseDTO;
import com.example.againandagain.exeptions.NestIdNotFound;

public interface NestGetByIdService {
    NestResponseDTO getNestById(Long id) throws NestIdNotFound;
}
