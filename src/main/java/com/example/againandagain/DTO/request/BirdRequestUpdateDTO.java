package com.example.againandagain.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class BirdRequestUpdateDTO {
//    @NotBlank(message = "Bird name should not be empty")
    private String name;
//    @NotBlank(message = "Bird color should not be empty")
    private String color;
//    @NotBlank(message = "Your bird can fly?")
    private Boolean canFly;
}
