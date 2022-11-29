package com.example.againandagain.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class BirdRequestAddDTO {
    private String name;
    private String color;
    private Boolean canFly;
    private Long id;
}
