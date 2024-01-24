package com.luv2code.springboot.thymeleafdemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {

    private String firstName;
    private String lastName;
    private String country;

}
