package com.example.againandagain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Nest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nest must have name")
    private String name;
    @NotBlank(message = "Nest must have address")
    private String address;
    @JsonManagedReference
    @OneToMany(mappedBy = "nest", fetch = FetchType.LAZY)
    private Set<Bird> birds;
}
