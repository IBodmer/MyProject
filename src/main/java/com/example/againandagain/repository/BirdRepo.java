package com.example.againandagain.repository;

import com.example.againandagain.model.Bird;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BirdRepo extends CrudRepository<Bird, Long> {
    @Query(value = "SELECT * FROM bird as b WHERE b.name_id = :name_id" ,nativeQuery = true)
    List<Bird> findAllBirdsWithNest(@Param("name_id") Long idNest);
}
