package com.example.againandagain.DTO.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class BirdRequestUpdateDTO {
    @NotBlank(message = "name should not be empty")
    private String name;
    private String color;
    private Boolean canFly;
}
