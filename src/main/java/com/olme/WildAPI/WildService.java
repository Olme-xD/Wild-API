package com.olme.WildAPI;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class WildService {
    @Autowired
    private WildRepository wildRepository;

    /**
     * Set a new wild animal in the database with profile picture.
     * @param wild
     * @param profilePicture
     * @return the new wild animal.
     */
    public Wild saveNewAnimal(Wild wild, MultipartFile profilePicture) {
        Wild newAnimal = wildRepository.save(wild);
        String originalFileName = profilePicture.getOriginalFilename();

        try {
            if (originalFileName != null && originalFileName.contains(".")) {
                String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
                String fileName = String.valueOf(newAnimal.getWildId()) + "." + fileExtension;
                Path filePath = Paths.get("src/main/resources/static/images/" + fileName);

                InputStream inputStream = profilePicture.getInputStream();

                Files.createDirectories(Paths.get("src/main/resources/static/images/"));
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                
                newAnimal.setImageUrl(fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to store profile picture", e);
        }

        // Save the entity *again* to update it with the imageUrl
        return wildRepository.save(newAnimal);
    }

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
        return wild.orElseThrow(() -> new NoSuchElementException("Wild animal with id " + id + " not found"));
    }

    /**
     * Set a new wild animal in the database.
     * @param wild
     * @return the new wild animal.
     */
    public Wild newWildAnimal(Wild wild) {
        if (wild.getHabitat() == null || wild.getHabitat().isEmpty()) {
            wild.setHabitat("Unknown");
        }
        if (wild.getSubspecies() == null || wild.getSubspecies().isEmpty()) {
            wild.setSubspecies("Unknown");
        }
        if (wild.getSource() == null || wild.getSource().isEmpty()) {
            wild.setSource("Unknown");  
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
        Wild existingWild = wildRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Wild animal with id " + id + " not found"));
        existingWild.setName(wild.getName());
        existingWild.setDescription(wild.getDescription());
        existingWild.setHabitat(wild.getHabitat());
        existingWild.setAge(wild.getAge());
        existingWild.setSubspecies(wild.getSubspecies());
        existingWild.setSource(wild.getSource());

        return wildRepository.save(existingWild);
    }

    /**
     * Delete a wild animal from the database.
     * @param id
     */
    public void deleteWildAnimal(long id) {
        if (wildRepository.existsById(id)) {
            wildRepository.deleteById(id);
            System.out.println("Wild animal with id " + id + " deleted");
        } else {
            throw new NoSuchElementException("Wild animal with id " + id + " not found");
        }
    }

    /**
     * Get all wild animals from the database by habitat.
     * @param habitat
     * @return the wild animal with the given habitat.
     */
    public Wild getWildAnimalByHabitat(String habitat) {
        if(habitat == null || habitat.isEmpty()) {
            throw new IllegalArgumentException("Habitat cannot be null or empty");
        } else if(wildRepository.findByHabitat(habitat) == null) {
            throw new NoSuchElementException("Wild animal with habitat " + habitat + " not found");
        }
        return wildRepository.findByHabitat(habitat);
    }

    /**
     * Get wild animals containing the string.
     * @param name
     * @return a string representation of all wild animals containing the string.
     */
    public List<Wild> getWildAnimalContainingString(String name){
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        } else if(wildRepository.getWildAnimalsByName(name).isEmpty()) {
            throw new NoSuchElementException("No wild animals containing the string " + name + " found");
        }
        return wildRepository.getWildAnimalsByName(name);
    }
}