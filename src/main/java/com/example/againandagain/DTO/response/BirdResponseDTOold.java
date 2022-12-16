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
public class BirdResponseDTOold {
    private Long id;
    private String name;
    private String color;
    private Boolean canFly;
    public static BirdResponseDTOold toBirdRespDTOold(Bird bird){
        BirdResponseDTOold birdResponseDTOold = new BirdResponseDTOold();
        birdResponseDTOold.setName(bird.getName());
        birdResponseDTOold.setColor(bird.getColor());
        birdResponseDTOold.setCanFly(bird.getCanFly());
        birdResponseDTOold.setId(bird.getId());
        return birdResponseDTOold;
    }
}
