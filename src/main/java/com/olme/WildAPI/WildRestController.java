package com.olme.WildAPI;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WildRestController {
    @Autowired
    private WildService wildService;

    /**
     * Get all wild animals from the database.
     */
    @GetMapping("/wild")
    public String getAllWildAnimals() {
        return wildService.getAllWildAnimals();
    }

    /**
     * Set a new wild animal in the database.
     */
    @PostMapping("/wild/new")
    public Wild newWildAnimal(String name, String description, String habitat, double age) {
        return wildService.newWildAnimal(name, description, habitat, age);
    }

    /**
     * Update a wild animal in the database.
     */
    @PutMapping("/wild/update")
    public Wild updateWildAnimal(long id, String name, String description, String habitat, double age) {
        return wildService.updateWildAnimal(id, name, description, habitat, age);
    }

    /**
     * Delete a wild animal from the database.
     */
    @DeleteMapping("/wild/delete")
    public String deleteWildAnimal(long id) {
        wildService.deleteWildAnimal(id);
        return "Deleted wild animal with id: " + id;
    }

    /**
     * Get all wild animals from the database by id.
     */
    @GetMapping("/wild/id")
    public String getWildAnimalById(long id) {
        return wildService.getWildAnimalById(id);
    }

    /**
     * Get all wild animals from the database by name.
     */
    @GetMapping("/wild/name")
    public String getWildAnimalByName(String name) {
        return wildService.getWildAnimalContainingString(name);
    }

    /**
     * Get all wild animals from the database by habitat.
     */
    @GetMapping("/wild/habitat")
    public Wild getWildAnimalByHabitat(String habitat) {
        return wildService.getWildAnimalByHabitat(habitat);
    }
}
