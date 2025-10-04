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

    String description;
    String habitat;
    double age;
    Date activeDate;

    public Wild() {}

    public Wild(String name, String description, String habitat, double age, Date activeDate) {
        this.name = name;
        this.description = description;
        this.habitat = habitat;
        this.age = age;
        this.activeDate = activeDate;
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

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    } 
}