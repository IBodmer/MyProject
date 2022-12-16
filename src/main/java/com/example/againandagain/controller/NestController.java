package com.example.againandagain.controller;

import com.example.againandagain.DTO.response.NestResponseDTO;
import com.example.againandagain.DTO.response.NestResponseLowWeightDTO;
import com.example.againandagain.service.NestServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/nest")
public class NestController {
    private final NestServiceImpl nestService;

    public NestController(NestServiceImpl nestService) {
        this.nestService = nestService;
    }

    @PostMapping
    public ResponseEntity<NestResponseLowWeightDTO> addNest(@RequestBody NestResponseLowWeightDTO nestRequestAddDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(nestService.addNest(nestRequestAddDTO));
    }

    @GetMapping
    public ResponseEntity<NestResponseDTO> getNestById(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(nestService.getNestById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NestResponseLowWeightDTO> updateNest(@RequestBody NestResponseLowWeightDTO nestRequestUpdateDTO, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(nestService.updateNest(nestRequestUpdateDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NestResponseLowWeightDTO> deleteNestById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(nestService.deleteNestById(id));
    }
}
