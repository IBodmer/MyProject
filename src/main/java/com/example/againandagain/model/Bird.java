package com.example.againandagain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
@NotNull
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bird {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Bird name should not be empty")
    private String name;
    @NotBlank(message = "Bird color should not be empty")
    private String color;
    private Boolean canFly;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "name_id")
    private Nest nest;

}
