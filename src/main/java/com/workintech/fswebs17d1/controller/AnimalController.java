package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/workintech")
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping("/animal")
    public List<Animal> getAllAnimals() {
        return animals.values().stream().toList();
    }

    @GetMapping("/animal/{id}")
    public Animal getAnimal(@PathVariable Integer id) {
        return animals.get(id);
    }

    @PostMapping("/animal")
    public Animal addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/animal/{id}")
    public Animal updateAnimal(@PathVariable Integer id, @RequestBody Animal animal) {
        if (animals.containsKey(id)) {
            animal.setId(id);
            animals.put(id, animal);
        }
        return animal;
    }
    @DeleteMapping("/animal/{id}")
    public String deleteAnimal(@PathVariable Integer id) {
        if (animals.containsKey(id)) {
            animals.remove(id);
            return "Animal delete " + id ;
        }
        return "Animal not found.";
    }
}
