package com.csc340.crud_api_jpa.demo.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    /**
     * Fetch all Animals.
     *
     * @return the list of all Animals.
     */
    public List<Animal> getAllAnimals(){
        return animalRepository.findAll();
    }
    /**
     * Fetch a specific animal.
     *
     * @param animalId the unique Animal id.
     * @return a unique Animal object.
     */
    public Animal getAnimalById(int animalId) {
        return animalRepository.findById(animalId).orElse(null);
    }
    /**
     * Fetch all animals whose species matches the search term.
     *
     * @param species the search key.
     * @return the list of matching Animals.
     */
    public List<Animal> getAnimalBySpecies(String species) {
        return animalRepository.getAnimalBySpecies(species);
        }
    /**
     * Fetch all animals with a common string in their name
     *
     * @param name the threshold
     * @return the list of matching Animals
     */
    public List<Animal> getAnimalByName(String name) {
        return animalRepository.getAnimalByName(name);
    }
    /**
     * Add a new Animal to the database.
     *
     * @param animal the new Animal to add.
     */
    public void addNewAnimal(Animal animal) {
        animalRepository.save(animal);
    }
    /**
     * Update an existing Animal.
     *
     * @param animalId the unique Animal id.
     * @param animal the new Animal details.
     */

    public void updateAnimal(int animalId, Animal animal) {
        Animal existing = getAnimalById(animalId);
        existing.setName(animal.getName());
        existing.setScientificName(animal.getScientificName());
        existing.setSpecies(animal.getSpecies());
        existing.setHabitat(animal.getHabitat());
        existing.setDescription(animal.getDescription());
        animalRepository.save(existing);
    }
    /**
     * Delete a unique Animal.
     *
     * @param animalId the unique Animal id.
     */
    public void deleteAnimalById(int animalId) {
        animalRepository.deleteById(animalId);
    }
}
