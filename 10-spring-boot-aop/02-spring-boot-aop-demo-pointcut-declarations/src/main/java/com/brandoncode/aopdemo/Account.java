package com.brandoncode.aopdemo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Account {
    private String name;
    private String level;

    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }
}
