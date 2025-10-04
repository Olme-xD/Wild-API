package com.olme.WildAPI;
import java.util.List;
import java.util.Date;
import java.util.Optional;
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
    public List<Wild> getAllWildAnimals() {
        return wildRepository.findAll();
    }

    /**
     * Get all wild animals from the database by id.
     * @param id
     */
    public Wild getWildAnimalById(long id) {
        Optional<Wild> wild = wildRepository.findById(id);
        if (wild.isPresent()) {
            return wild.get();
        }
        return null;
    }

    /**
     * Set a new wild animal in the database.
     * @param wild
     * @return the new wild animal.
     */
    public Wild newWildAnimal(Wild wild) {
        if (wild.getActiveDate() == null) {
            wild.setActiveDate(new Date());
        }
        return wildRepository.save(wild);
    }

    /**
     * Update a wild animal in the database.
     * @param id
     * @param wild
     * @return the updated wild animal.
     */
    public Wild updateWildAnimal(long id, Wild wild) {
        Optional<Wild> existingWildOptional = wildRepository.findById(id);
        if (existingWildOptional.isPresent()) {
            Wild existingWild = existingWildOptional.get();
            existingWild.setName(wild.getName());
            existingWild.setDescription(wild.getDescription());
            existingWild.setHabitat(wild.getHabitat());
            existingWild.setAge(wild.getAge());
            return wildRepository.save(existingWild);
        }
        return null;
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
        return wildRepository.findByHabitat(habitat.toLowerCase());
    }

    /**
     * Get wild animals containing the string.
     * @param name
     * @return a string representation of all wild animals containing the string.
     */
    public List<Wild> getWildAnimalContainingString(String name){
        return wildRepository.getWildAnimalsByName(name.toLowerCase());
    }
}