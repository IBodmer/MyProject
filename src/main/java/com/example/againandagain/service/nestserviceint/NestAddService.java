package com.example.againandagain.service.nestserviceint;

import com.example.againandagain.DTO.request.NestRequestAddDTO;
import com.example.againandagain.exeptions.NestAlreadyAdded;
import com.example.againandagain.model.Nest;

public interface NestAddService {
    String addNest(NestRequestAddDTO nestRequestAddDTO) throws NestAlreadyAdded;
}
