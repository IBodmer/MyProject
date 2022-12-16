package com.example.againandagain.service.nestserviceint;

import com.example.againandagain.DTO.request.NestRequestAddDTO;
import com.example.againandagain.DTO.request.NestRequestUpdateDTO;
import com.example.againandagain.DTO.response.NestResponseDTO;
import com.example.againandagain.DTO.response.NestResponseLowWeightDTO;
import com.example.againandagain.exeptions.alreadyadded.NestAlreadyAdded;
import com.example.againandagain.exeptions.notfound.NestNotFoundById;

public interface NestService {
    NestResponseLowWeightDTO addNest(NestRequestAddDTO nestRequestAddDTO) throws NestAlreadyAdded;
    NestResponseLowWeightDTO deleteNestById(Long id) throws NestNotFoundById;
    NestResponseDTO getNestById(Long id) throws NestNotFoundById;
    NestResponseLowWeightDTO updateNest(NestRequestUpdateDTO nestRequestUpdateDTO, Long id) throws NestNotFoundById;
}
