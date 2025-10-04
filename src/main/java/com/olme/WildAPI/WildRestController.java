package com.olme.WildAPI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class WildRestController {
    @Autowired
    private WildService wildService;

    /**
     * Get all wild animals from the database.
     */
    @GetMapping("/wild")
    public List<Wild> getAllWildAnimals() {
        return wildService.getAllWildAnimals();
    }

    /**
     * Set a new wild animal in the database.
     */
    @PostMapping("/wild/new")
    public Wild newWildAnimal(@RequestBody Wild wild) {
        return wildService.newWildAnimal(wild);
    }

    /**
     * Update a wild animal in the database.
     */
    @PutMapping("/wild/update")
    public Wild updateWildAnimal(@RequestParam long id, @RequestBody Wild wild) {
        return wildService.updateWildAnimal(id, wild);
    }

    /**
     * Delete a wild animal from the database.
     */
    @DeleteMapping("/wild/delete")
    public String deleteWildAnimal(@RequestParam long id) {
        wildService.deleteWildAnimal(id);
        return "Deleted wild animal with id: " + id;
    }

    /**
     * Get all wild animals from the database by id.
     */
    @GetMapping("/wild/id")
    public Wild getWildAnimalById(@RequestParam long id) {
        return wildService.getWildAnimalById(id);
    }

    /**
     * Get all wild animals from the database by name.
     */
    @GetMapping("/wild/name")
    public List<Wild> getWildAnimalByName(@RequestParam String name) {
        return wildService.getWildAnimalContainingString(name);
    }

    /**
     * Get all wild animals from the database by habitat.
     */
    @GetMapping("/wild/habitat")
    public Wild getWildAnimalByHabitat(@RequestParam String habitat) {
        return wildService.getWildAnimalByHabitat(habitat);
    }
}