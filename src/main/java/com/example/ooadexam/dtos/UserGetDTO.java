package com.example.ooadexam.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserGetDTO {

    private Long id;

    private String name;

    private String surname;

}
