package com.olme.WildAPI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

@RestController
public class WildRestController {
    @Autowired
    private WildService wildService;

    /**
     * Get all wild animals from the database.
     */
    @GetMapping("/api/wild")
    public List<Wild> getAllWildAnimals() {
        return wildService.getAllWildAnimals();
    }

    /**
     * Put a new wild animal in the database.
     */
    @PostMapping("/api/wild/new")
    public Wild saveNewAnimal(@RequestPart("wild") Wild wild, @RequestParam("profilePicture") MultipartFile profilePicture) {
        return wildService.saveNewAnimal(wild, profilePicture);
    }

    /**
     * Update a wild animal in the database.
     */
    @PutMapping("/api/wild/update")
    public Wild updateWildAnimal(@RequestParam long id, @RequestBody Wild wild) {
        return wildService.updateWildAnimal(id, wild);
    }

    /**
     * Delete a wild animal from the database.
     */
    @DeleteMapping("/api/wild/delete")
    public void deleteWildAnimal(@RequestParam long id) {
        wildService.deleteWildAnimal(id);
    }

    /**
     * Get all wild animals from the database by id.
     */
    @GetMapping("/api/wild/id")
    public Wild getWildAnimalById(@RequestParam long id) {
        return wildService.getWildAnimalById(id);
    }

    /**
     * Get all wild animals from the database by name.
     */
    @GetMapping("/api/wild/name")
    public List<Wild> getWildAnimalByName(@RequestParam String name) {
        return wildService.getWildAnimalContainingString(name);
    }

    /**
     * Get all wild animals from the database by habitat.
     */
    @GetMapping("/api/wild/habitat")
    public Wild getWildAnimalByHabitat(@RequestParam String habitat) {
        return wildService.getWildAnimalByHabitat(habitat);
    }
}