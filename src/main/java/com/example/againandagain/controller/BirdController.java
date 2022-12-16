package com.example.againandagain.controller;

import com.example.againandagain.DTO.request.BirdRequestAddDTO;
import com.example.againandagain.DTO.request.BirdRequestUpdateDTO;
import com.example.againandagain.DTO.response.BirdResponseDTO;
import com.example.againandagain.model.Bird;
import com.example.againandagain.service.BirdServiceImpl;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
@RequestMapping("api/v1/bird")
public class BirdController {
    private final BirdServiceImpl birdServiceimpl;

    public BirdController(BirdServiceImpl birdServiceimpl) {
        this.birdServiceimpl = birdServiceimpl;
    }

    @PostMapping
    public ResponseEntity<BirdResponseDTO> addBird(@Valid @RequestBody BirdRequestAddDTO bird) {
        return ResponseEntity.status(HttpStatus.CREATED).body(birdServiceimpl.addBird(bird));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BirdResponseDTO> updateBirdById(@PathVariable Long id, @RequestBody BirdRequestUpdateDTO birdRequestUpdateDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(birdServiceimpl.updateBirdById(id, birdRequestUpdateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BirdResponseDTO> deleteBirdById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(birdServiceimpl.deleteBirdById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BirdResponseDTO> getBirdById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(birdServiceimpl.getBirdById(id));
    }

    @GetMapping
    public ResponseEntity<List<Bird>> findAllBirdsWithNest(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(birdServiceimpl.findAllBirdsWithNest(id));

    }
}
