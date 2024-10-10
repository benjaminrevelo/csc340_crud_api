package com.csc340.crud_api_jpa.demo.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals in the database.
     * http://localhost:8080/animals/all
     *
     * @return a list of Animal objects.
     */
    @GetMapping("/all")
    public List<Animal> getAllAnimals(){
        return service.getAllAnimals();
    }
    /**
     * Get a specific Animal by id.
     * http://localhost:8080/animals/2
     *
     * @param animalId the unique id for an Animal.
     * @return One Animal object.
     */
    @GetMapping("/{animalId}")
    public Animal getOneAnimal(@PathVariable int animalId) {
        return service.getAnimalById(animalId);
    }
    /**
     * Get a list of animals based on specie
     * http://localhost:8080/animals/species/bird
     *
     * @param species the specie for an Animal
     * @return list of Animal objects matching the species key.
     */
    @GetMapping("/species/{species}")
    public List<Animal> getAnimalBySpecies(@PathVariable String species) {
        return service.getAnimalBySpecies(species);
    }
    /**
     * Get a list of animals who contain a common word in their name
     * http://localhost:8080/animals/blue
     *
     * @param name the name for an Animal
     * @return list of Animal objects matching the search key.
     */
    @GetMapping("/{name}")
    public List<Animal> getAnimalByName(@RequestParam String name) {
        return service.getAnimalByName(name);
    }
    /**
     * Create a new Animal entry.
     * http://localhost:8080/animals/new --data '{ "animalId": 4, "name": "Cardinal", "scientificName": "", species: "", habitat: "",  description: ""}'
     *
     * @param animal the new Animal object.
     * @return the updated list of Animals.
     */
    @PostMapping("/new")
    public List<Animal> addNewAnimal(@RequestBody Animal animal){
        service.addNewAnimal(animal);
        return service.getAllAnimals();
    }
    /**
     * Update an existing Animal object.
     * http://localhost:8080/animals/update/2 --data '{ "animalId": 1, "name": "Sparrow", "scientificName": "", species: "", habitat: "",  description: ""}'
     *
     * @param animalId the unique Animal id.
     * @param animal the new update Animal details.
     * @return the updated Animal object.
     */
    @PutMapping("/update/{animalId}")
    public Animal updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        service.updateAnimal(animalId, animal);
        return service.getAnimalById(animalId);
    }
    /**
     * Delete a Animal object.
     * http://localhost:8080/animals/delete/2
     *
     * @param animalId the unique Animal id.
     * @return the updated list of Animals.
     */
    @DeleteMapping("/delete/{animalId}")
    public List<Animal> deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return service.getAllAnimals();
    }

}
