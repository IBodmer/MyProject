package com.example.againandagain.controller;

import com.example.againandagain.DTO.request.BirdRequestAddDTO;
import com.example.againandagain.DTO.request.BirdRequestUpdateDTO;
import com.example.againandagain.service.BirdServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/birds")
public class BirdController {
    private final BirdServiceImpl birdServiceimpl;

    public BirdController(BirdServiceImpl birdServiceimpl) {
        this.birdServiceimpl = birdServiceimpl;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addBird(@RequestBody BirdRequestAddDTO bird) {
        try {

            return ResponseEntity.ok(birdServiceimpl.addBird(bird));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBirdById(@PathVariable Long id, @RequestBody BirdRequestUpdateDTO birdRequestUpdateDTO) {
        try {

            return ResponseEntity.ok(birdServiceimpl.updateBirdById(id, birdRequestUpdateDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBirdById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(birdServiceimpl.deleteBirdById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getBirdById(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(birdServiceimpl.getBirdById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> findAllBirdsWithNest(@PathVariable Long id){
        try {
            return ResponseEntity.ok(birdServiceimpl.findAllBirdsWithNest(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
