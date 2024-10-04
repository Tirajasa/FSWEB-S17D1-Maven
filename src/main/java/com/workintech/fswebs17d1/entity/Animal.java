package com.workintech.fswebs17d1.entity;

import jakarta.annotation.PostConstruct;

public class Animal {
    private Integer id;
    private String name;


    public Animal(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Animal(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
