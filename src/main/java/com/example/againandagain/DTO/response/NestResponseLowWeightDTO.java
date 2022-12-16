package com.example.againandagain.DTO.response;

import com.example.againandagain.model.Nest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class NestResponseLowWeightDTO {
    private String name;
    private String address;

    public static NestResponseLowWeightDTO toNestResponseLow(Nest nest) {
        NestResponseLowWeightDTO nestResponseLowWeightDTO = new NestResponseLowWeightDTO();
        nestResponseLowWeightDTO.setName(nest.getName());
        nestResponseLowWeightDTO.setAddress(nest.getAddress());
        return nestResponseLowWeightDTO;
    }
}
