package com.example.againandagain.controller;

import com.example.againandagain.DTO.request.NestRequestAddDTO;
import com.example.againandagain.DTO.request.NestRequestUpdateDTO;
import com.example.againandagain.DTO.response.NestResponseDTO;
import com.example.againandagain.exeptions.NestAlreadyAdded;
import com.example.againandagain.exeptions.NestIdNotFound;
import com.example.againandagain.model.Nest;
import com.example.againandagain.service.NestServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nests")
public class NestController {
    private final NestServiceImpl nestService;

    public NestController(NestServiceImpl nestService) {
        this.nestService = nestService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNest(@RequestBody NestRequestAddDTO nestRequestAddDTO) {
        try {
            return ResponseEntity.ok(nestService.addNest(nestRequestAddDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getNestById(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(nestService.getNestById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNest(@RequestBody NestRequestUpdateDTO nestRequestUpdateDTO, @PathVariable Long id) {
        try {
            return ResponseEntity.ok(nestService.updateNest(nestRequestUpdateDTO, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNestById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(nestService.deleteNestById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
