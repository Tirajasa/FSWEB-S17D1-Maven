package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import com.workintech.fswebs17d1.utils.Validation;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/animal")
public class AnimalController {

    private Map<Integer, Animal> animals;

    @PostConstruct
    public void loadAll(){
        this.animals=new HashMap<>();
        this.animals.put(1,new Animal(1,"monkey"));
    }


    @GetMapping
    public List<Animal> getAnimals(){
        System.out.println(" Animals list is trigerred! ");
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable("id") Integer id){
        Validation.checkId(id);
        System.out.println("Animals are got by ID");
        return animals.get(id);
    }

}
