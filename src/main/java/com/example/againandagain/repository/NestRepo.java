package com.example.againandagain.repository;

import com.example.againandagain.DTO.response.NestResponseDTO;
import com.example.againandagain.model.Nest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestRepo extends CrudRepository<Nest, Long> {
    Nest findByNameAndAddress(String name, String address);

}
