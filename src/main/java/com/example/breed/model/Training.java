package com.example.breed.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Training implements Serializable {
    @Id
    @Column(updatable = false, nullable = false, unique = true, length = 36)
    private String id;
    private String name;
    private Date date;
    private String location;
    @ManyToMany(mappedBy = "trainings")
    private List<Dog> dogs;

    public Training(String name, Date date, String location) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.date = date;
        this.location = location;
    }

    public Training() {
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
        return "Training{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", dogs=" + dogs +
                '}';
    }
}
