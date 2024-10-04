package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import com.workintech.fswebs17d1.utils.Validation;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/workintech/animal")
public class AnimalController {

    private Map<Integer, Animal> animals;

    @Value("${project.developer.fullname}")
    private String developerName;

    @Value("${course.name}")
    private String courseName;


    @PostConstruct
    public void loadAll(){
        System.out.println("PostConstruct has worked!");
        this.animals=new HashMap<>();
        this.animals.put(1,new Animal(1,"monkey"));
    }


    @GetMapping("/config")
    public String getCustomConfigValues(){
        return developerName + " --- " + courseName;
    }
    @GetMapping
    public List<Animal> getAnimals(){
        System.out.println(" Animals list is trigerred!");
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable("id") Integer id){
        Validation.checkId(id);
        System.out.println("Animals are got by ID");
        return animals.get(id);
    }
    @PostMapping
    public Animal addAnimal( @RequestBody Animal animal){
        System.out.println("New animal has been saved.");
        return animals.put(animal.getId(),animal);
    }
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable("id")Integer id, @RequestBody Animal newAnimal){

        System.out.println("Animal with an "+id+ " is updated with "+newAnimal);
        animals.replace(id,newAnimal);
        return this.animals.get(id);
    }
    @DeleteMapping("/{id}")
    public Animal deleteAnimal(@PathVariable("id") Integer id){
        Validation.checkId(id);
        System.out.println("Animal is deleted");
        animals.remove(id);
        return animals.get(id);
    }


}
