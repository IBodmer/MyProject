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
public class BirdGetResponseDTO {
    private String name;
    private String color;
    private Boolean canFly;
    private String nameNest;
    public static BirdGetResponseDTO toBirdRespGetDTO(Bird bird){
        BirdGetResponseDTO birdGetResponseDTO = new BirdGetResponseDTO();
        birdGetResponseDTO.setName(bird.getName());
        birdGetResponseDTO.setColor(bird.getColor());
        birdGetResponseDTO.setCanFly(bird.getCanFly());
        birdGetResponseDTO.setNameNest(bird.getNest().getName());
        return birdGetResponseDTO;
    }
}
