package com.example.againandagain.DTO.response;

import com.example.againandagain.model.Bird;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NotNull
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class BirdResponseDTO {
    private Long id;
    private String name;
    private String color;
    private Boolean canFly;
    public static BirdResponseDTO toBirdRespDTO(Bird bird){
        BirdResponseDTO birdResponseDTO = new BirdResponseDTO();
        birdResponseDTO.setName(bird.getName());
        birdResponseDTO.setColor(bird.getColor());
        birdResponseDTO.setCanFly(bird.getCanFly());
        birdResponseDTO.setId(bird.getId());
        return birdResponseDTO;
    }
}
