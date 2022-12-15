package com.example.againandagain.service.nestserviceint;

import com.example.againandagain.DTO.request.NestRequestAddDTO;
import com.example.againandagain.DTO.request.NestRequestUpdateDTO;
import com.example.againandagain.DTO.response.NestResponseDTO;
import com.example.againandagain.exeptions.NestAlreadyAdded;
import com.example.againandagain.exeptions.NestIdNotFound;

public interface NestService {
    String addNest(NestRequestAddDTO nestRequestAddDTO) throws NestAlreadyAdded;
    String deleteNestById(Long id) throws NestIdNotFound;
    NestResponseDTO getNestById(Long id) throws NestIdNotFound;
    String updateNest(NestRequestUpdateDTO nestRequestUpdateDTO, Long id) throws NestIdNotFound;
}
