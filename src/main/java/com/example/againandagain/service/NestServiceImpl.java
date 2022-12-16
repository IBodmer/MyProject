package com.example.againandagain.service;

import com.example.againandagain.DTO.request.NestRequestAddDTO;
import com.example.againandagain.DTO.request.NestRequestUpdateDTO;
import com.example.againandagain.DTO.response.BirdResponseDTOold;
import com.example.againandagain.DTO.response.NestResponseDTO;
import com.example.againandagain.exeptions.NestAlreadyAdded;
import com.example.againandagain.exeptions.NestNotFoundById;
import com.example.againandagain.model.Nest;
import com.example.againandagain.repository.NestRepo;
import com.example.againandagain.service.nestserviceint.NestService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.stream.Collectors;

@Service
public class NestServiceImpl implements NestService {
    private final NestRepo nestRepo;

    public NestServiceImpl(NestRepo nestRepo) {
        this.nestRepo = nestRepo;
    }

    @Override
    public String addNest(NestRequestAddDTO nestRequestAddDTO) throws NestAlreadyAdded {
        if (nestRepo.findByNameAndAddress(nestRequestAddDTO.getName(), nestRequestAddDTO.getAddress()) != null)
            throw new NestAlreadyAdded("Гнездо уже добавлено");
        Nest nest = Nest.builder()
                .birds(new HashSet<>())
                .name(nestRequestAddDTO.getName())
                .address(nestRequestAddDTO.getAddress())
                .build();
        nestRepo.save(nest);
        return "ok";
    }

    @Override
    public NestResponseDTO getNestById(Long id) throws NestNotFoundById {
        Nest byId = nestRepo.findById(id).orElseThrow(() -> new NestNotFoundById("Гнезда по id: " + id + " не найдено"));

        return NestResponseDTO.builder()
                .name(byId.getName())
                .address(byId.getAddress())
                .birds(byId.getBirds().stream().map(BirdResponseDTOold::toBirdRespDTOold).collect(Collectors.toSet()))
                .build();
    }

    @Override
    public String updateNest(NestRequestUpdateDTO nestRequestUpdateDTO, Long id) throws NestNotFoundById {
        Nest nestById = nestRepo.findById(id).orElseThrow(() -> new NestNotFoundById("Гнезда по id: " + id + " не найдено"));
        nestById.setName(nestRequestUpdateDTO.getName());
        nestById.setAddress(nestRequestUpdateDTO.getAddress());
        nestRepo.save(nestById);
        return "ok";
    }

    @Override
    public String deleteNestById(Long id) throws NestNotFoundById {
        if (nestRepo.findById(id).isPresent()) {
            nestRepo.deleteById(id);
        } else throw new NestNotFoundById("Гнезда по id: " + id + " не найдено");
        return "ok";
    }
}
