package com.example.againandagain.service;

import com.example.againandagain.DTO.request.BirdRequestAddDTO;
import com.example.againandagain.DTO.request.BirdRequestUpdateDTO;
import com.example.againandagain.DTO.response.BirdGetResponseDTO;
import com.example.againandagain.exeptions.BirdAlreadyAdded;
import com.example.againandagain.exeptions.BirdNotFoundById;
import com.example.againandagain.exeptions.NestIdNotFound;
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
    public String addBird(BirdRequestAddDTO bird) throws NestIdNotFound, BirdAlreadyAdded {

        Nest byId = nestRepo.findById(bird.getId()).
                orElseThrow(() -> new NestIdNotFound("Гнезда по id: " + bird.getId() + " не найдено"));
        Bird realBird = Bird.builder()
                .name(bird.getName())
                .color(bird.getColor())
                .canFly(bird.getCanFly())
                .nest(byId).build();
        byId.getBirds().add(realBird);
        birdRepo.save(realBird);
        return "ok";
    }

    @Override
    public String updateBirdById(Long id, BirdRequestUpdateDTO birdRequestUpdateDTO) throws BirdNotFoundById {
        Bird bird = birdRepo.findById(id).orElseThrow(() -> new BirdNotFoundById("Птицы по id: " + id + " не найдено"));
        bird.setName(birdRequestUpdateDTO.getName());
        bird.setColor(birdRequestUpdateDTO.getColor());
        bird.setCanFly(birdRequestUpdateDTO.getCanFly());
        birdRepo.save(bird);
        return "ok";
    }

    @Override
    public String deleteBirdById(Long id) throws BirdNotFoundById {
        if (birdRepo.findById(id).isPresent()) {
            birdRepo.deleteById(id);
        } else throw new BirdNotFoundById("Птицы по id: " + id + " не найдено");
        return "ok";
    }

    @Override
    public BirdGetResponseDTO getBirdById(Long id) throws BirdNotFoundById {
        Bird bird = birdRepo.findById(id).orElseThrow(() -> new BirdNotFoundById("Птицы по id: " + id + " не найдено"));
        return BirdGetResponseDTO.toBirdRespGetDTO(bird);
    }

    public List<Bird> findAllBirdsWithNest(Long id) throws NestIdNotFound {
        if (nestRepo.findById(id).isPresent()) {
            return birdRepo.findAllBirdsWithNest(id);
        } else throw new NestIdNotFound("Такого гнезда нет");
    }
}
