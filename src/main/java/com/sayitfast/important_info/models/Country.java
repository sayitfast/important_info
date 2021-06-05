package com.sayitfast.important_info.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country extends CommonObject {


    private String code;
    private String capital;
    @NotBlank(message = "description is mandatory")
    private String description;
    private String nationality;
    private String continent;

    @OneToMany(mappedBy = "country")
    private List<State> states;
}