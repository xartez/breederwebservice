package com.example.breed.dto;

import com.example.breed.model.Dog;
import com.example.breed.model.Training;

import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

public class TrainingDTO {
    private String name;
    private Date date;
    private String location;
    private List<Dog> dogs;

    public TrainingDTO(Training training) {
        this.name = training.getName();
        this.date = training.getDate();
        this.location = training.getLocation();
        this.dogs = training.getDogs();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    @Override
    public String toString() {
        return "TrainingDTO{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", dogs=" + dogs +
                '}';
    }
}
