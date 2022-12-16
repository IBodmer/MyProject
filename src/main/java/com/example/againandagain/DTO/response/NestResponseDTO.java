package com.example.againandagain.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class NestResponseDTO {
    private String name;
    private String address;
    private Set<BirdResponseDTOold> birds;
}
