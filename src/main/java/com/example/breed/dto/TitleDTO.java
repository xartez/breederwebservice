package com.example.breed.dto;

import com.example.breed.model.Dog;
import com.example.breed.model.Title;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class TitleDTO {
    private String name;
    private LocalDate date;
    private String location;
    private Dog dog;


    public TitleDTO(Title title) {
        this.name = title.getName();
        this.date = title.getDate();
        this.location = title.getLocation();
        this.dog = title.getDog();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "TitleDTO{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", dog=" + dog +
                '}';
    }
}
