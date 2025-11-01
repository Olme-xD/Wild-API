package com.olme.WildAPI;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Wild {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long wildId;

    @Column(nullable = false)
    String name;

    @Column(length = 2000, nullable = false)
    String description;

    @Column(nullable = false)
    String subspecies;
    
    String habitat;
    Double age;
    Date activeDate = Date.from(new Date().toInstant());
    String imageUrl;
    String source;

    public Wild() {}

    public Wild(String name, String description, String habitat, double age) {
        this.name = name;
        this.description = description;
        this.habitat = habitat;
        this.age = age;
        this.activeDate = Date.from(new Date().toInstant());
    }

    public long getWildId() {
        return wildId;
    }

    public void setWildId(long wildId) {
        this.wildId = wildId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubspecies() {
        return subspecies;
    }

    public void setSubspecies(String subspecies) {
        this.subspecies = subspecies;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}