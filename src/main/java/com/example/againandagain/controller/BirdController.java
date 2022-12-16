package com.example.againandagain.controller;

import com.example.againandagain.DTO.request.BirdRequestAddDTO;
import com.example.againandagain.DTO.request.BirdRequestUpdateDTO;
import com.example.againandagain.DTO.response.BirdResponseDTO;
import com.example.againandagain.exeptions.BirdAlreadyAdded;
import com.example.againandagain.exeptions.BirdNotFoundById;
import com.example.againandagain.exeptions.NestNotFoundById;
import com.example.againandagain.model.Bird;
import com.example.againandagain.service.BirdServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bird")
public class BirdController {
    private final BirdServiceImpl birdServiceimpl;

    public BirdController(BirdServiceImpl birdServiceimpl) {
        this.birdServiceimpl = birdServiceimpl;
    }

    @PostMapping

    public ResponseEntity<BirdResponseDTO> addBird(@RequestBody BirdRequestAddDTO bird) throws BirdAlreadyAdded, NestNotFoundById {
        return ResponseEntity.status(HttpStatus.CREATED).body(birdServiceimpl.addBird(bird));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BirdResponseDTO> updateBirdById(@PathVariable Long id, @RequestBody BirdRequestUpdateDTO birdRequestUpdateDTO) throws BirdNotFoundById {
        return ResponseEntity.status(HttpStatus.OK).body(birdServiceimpl.updateBirdById(id, birdRequestUpdateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BirdResponseDTO> deleteBirdById(@PathVariable Long id) throws BirdNotFoundById {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(birdServiceimpl.deleteBirdById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BirdResponseDTO> getBirdById(@PathVariable Long id) throws BirdNotFoundById {
        return ResponseEntity.status(HttpStatus.OK).body(birdServiceimpl.getBirdById(id));
    }

    @GetMapping
    public ResponseEntity<List<Bird>> findAllBirdsWithNest(@RequestParam Long id) throws NestNotFoundById {
        return ResponseEntity.status(HttpStatus.OK).body(birdServiceimpl.findAllBirdsWithNest(id));

    }
}
