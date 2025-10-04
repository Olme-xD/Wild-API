package com.olme.WildAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WildService {
    @Autowired
    private WildRepository wildRepository;

    /**
     * Get all wild animals from the database.
     * @returns a string representation of all wild animals.
     */
    public String getAllWildAnimals() {
        return wildRepository.findAll().toString();
    }

    /**
     * Get all wild animals from the database by id.
     * @param id
     */
    public String getWildAnimalById(long id) {
        return wildRepository.getWildAnimalsById(id).toString();
    }

    /**
     * Set a new wild animal in the database.
     * @param name
     * @param description
     * @param habitat
     * @param age
     * @return the new wild animal.
     */
    public Wild newWildAnimal(String name, String description, String habitat, double age) {
        Wild wild = new Wild(name, description, habitat, age, null);
        return wildRepository.save(wild);
    }

    /**
     * Update a wild animal in the database.
     * @param id
     * @param name
     * @param description
     * @param habitat
     * @param age
     * @return the updated wild animal.
     */
    public Wild updateWildAnimal(long id, String name, String description, String habitat, double age) {
        Wild wild = wildRepository.findById(id).orElseThrow();
        wild.setName(name);
        wild.setDescription(description);
        wild.setHabitat(habitat);
        wild.setAge(age);
        return wildRepository.save(wild);
    }

    /**
     * Delete a wild animal from the database.
     * @param id
     */
    public void deleteWildAnimal(long id) {
        wildRepository.deleteById(id);
    }

    /**
     * Get all wild animals from the database by habitat.
     * @param habitat
     * @return the wild animal with the given habitat.
     */
    public Wild getWildAnimalByHabitat(String habitat) {
        return wildRepository.findByHabitat(habitat);
    }

    /**
     * Get wild animals containing the string.
     * @param name
     * @return a string representation of all wild animals containing the string.
     */
    public String getWildAnimalContainingString(String name){
        return wildRepository.getWildAnimalsByName(name).toString();
    }
}
