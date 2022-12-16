package com.example.againandagain.service.nestserviceint;

import com.example.againandagain.DTO.request.NestRequestAddDTO;
import com.example.againandagain.DTO.request.NestRequestUpdateDTO;
import com.example.againandagain.DTO.response.NestResponseDTO;
import com.example.againandagain.exeptions.NestAlreadyAdded;
import com.example.againandagain.exeptions.NestNotFoundById;

public interface NestService {
    String addNest(NestRequestAddDTO nestRequestAddDTO) throws NestAlreadyAdded;
    String deleteNestById(Long id) throws NestNotFoundById;
    NestResponseDTO getNestById(Long id) throws NestNotFoundById;
    String updateNest(NestRequestUpdateDTO nestRequestUpdateDTO, Long id) throws NestNotFoundById;
}
