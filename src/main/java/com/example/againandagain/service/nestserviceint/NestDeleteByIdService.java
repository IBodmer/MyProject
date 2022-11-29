package com.example.againandagain.service.nestserviceint;

import com.example.againandagain.exeptions.NestIdNotFound;

public interface NestDeleteByIdService {
    String deleteNestById(Long id) throws NestIdNotFound;
}
