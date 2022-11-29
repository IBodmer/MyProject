package com.example.againandagain.service.nestserviceint;

import com.example.againandagain.DTO.request.NestRequestUpdateDTO;
import com.example.againandagain.exeptions.NestIdNotFound;
import com.example.againandagain.model.Nest;

public interface NestUpdateService {
    String updateNest(NestRequestUpdateDTO nestRequestUpdateDTO, Long id) throws NestIdNotFound;
}
