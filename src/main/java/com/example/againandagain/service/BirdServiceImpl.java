package com.example.againandagain.service;

import com.example.againandagain.DTO.request.BirdRequestAddDTO;
import com.example.againandagain.DTO.request.BirdRequestUpdateDTO;
import com.example.againandagain.DTO.response.BirdResponseDTO;
import com.example.againandagain.exeptions.BirdAlreadyAdded;
import com.example.againandagain.exeptions.BirdNotFoundById;
import com.example.againandagain.exeptions.NestNotFoundById;
import com.example.againandagain.model.Bird;
import com.example.againandagain.model.Nest;
import com.example.againandagain.repository.BirdRepo;
import com.example.againandagain.repository.NestRepo;
import com.example.againandagain.service.birdserviceint.BirdService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirdServiceImpl implements BirdService {
    private final BirdRepo birdRepo;
    private final NestRepo nestRepo;

    public BirdServiceImpl(BirdRepo birdRepo, NestRepo nestRepo) {
        this.birdRepo = birdRepo;
        this.nestRepo = nestRepo;
    }

    @Override
    public BirdResponseDTO addBird(BirdRequestAddDTO bird) throws NestNotFoundById, BirdAlreadyAdded {
        // Надо продумать логику. насчет птица без гнезда
        Nest byId = nestRepo.findById(bird.getNestId()).
                orElseThrow(() -> new NestNotFoundById("Гнезда по id: " + bird.getNestId() + " не найдено"));
        Bird realBird = Bird.builder()
                .name(bird.getName())
                .color(bird.getColor())
                .canFly(bird.getCanFly())
                .nest(byId).build();
        byId.getBirds().add(realBird);
        return BirdResponseDTO.toBirdRespDTO(birdRepo.save(realBird));
    }

    @Override
    public BirdResponseDTO updateBirdById(Long id, BirdRequestUpdateDTO birdRequestUpdateDTO) throws BirdNotFoundById {
        Bird bird = birdRepo.findById(id).orElseThrow(() -> new BirdNotFoundById("Птицы по id: " + id + " не найдено"));
        bird.setName(birdRequestUpdateDTO.getName());
        bird.setColor(birdRequestUpdateDTO.getColor());
        bird.setCanFly(birdRequestUpdateDTO.getCanFly());
        return BirdResponseDTO.toBirdRespDTO(birdRepo.save(bird));
    }

    @Override
    public BirdResponseDTO deleteBirdById(Long id) throws BirdNotFoundById {
        Bird bird = birdRepo.findById(id).orElseThrow(() -> new BirdNotFoundById("Птицы по id: " + id + " не найдено"));
        birdRepo.deleteById(bird.getId());
        return BirdResponseDTO.toBirdRespDTO(bird);
    }

    @Override
    public BirdResponseDTO getBirdById(Long id) throws BirdNotFoundById {
        Bird bird = birdRepo.findById(id).orElseThrow(() -> new BirdNotFoundById("Птицы по id: " + id + " не найдено"));
        return BirdResponseDTO.toBirdRespDTO(bird);
    }

    public List<Bird> findAllBirdsWithNest(Long id) throws NestNotFoundById {
        if (nestRepo.findById(id).isPresent()) {
            return birdRepo.findAllBirdsWithNest(id);
        } else throw new NestNotFoundById("Такого гнезда нет");
    }
}
