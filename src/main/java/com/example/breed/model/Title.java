package com.example.breed.model;

import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
public class Title implements Serializable {
    @Id
    @Column(updatable = false, nullable = false, unique = true, length = 36)
    private String id;
    private String name;
    private LocalDate date;
    private String location;
    @ManyToOne(fetch = FetchType.LAZY)
    private Dog dog;

    public Title(String name, LocalDate date, String location) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.date = date;
        this.location = location;
    }

    public Title() {
        this.id = UUID.randomUUID().toString();


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "Title{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                '}';
    }
}
