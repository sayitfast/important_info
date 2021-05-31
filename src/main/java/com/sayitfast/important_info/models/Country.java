package com.sayitfast.important_info.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String capital;
    @NotBlank(message = "description is mandatory")
    private String description;
    private String nationality;
    private String continent;

    @OneToMany(mappedBy = "country")
    private List<State> states;
}