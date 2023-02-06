package com.example.breed.dto;

import com.example.breed.model.Dog;
import com.example.breed.model.Owner;

import java.util.List;

public class OwnerDTO {
    private String name;
    private String lastName;
    private String location;
    private String kennel;
    private List<Dog> dogs;

    public OwnerDTO(Owner owner) {
        this.name = owner.getName();
        this.lastName = owner.getLastName();
        this.location = owner.getLocation();
        this.kennel = owner.getKennel();
        this.dogs = owner.getDogs();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getKennel() {
        return kennel;
    }

    public void setKennel(String kennel) {
        this.kennel = kennel;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    @Override
    public String toString() {
        return "OwnerDTO{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", location='" + location + '\'' +
                ", kennel='" + kennel + '\'' +
                ", dogs=" + dogs +
                '}';
    }
}
