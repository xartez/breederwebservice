package com.example.breed.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Litter implements Serializable {
    @Id
    @Column(updatable = false, nullable = false, unique = true, length = 36)
    private String id;
    private char letter;
    private String name;
    private String breed;
    private String mother;
    private String father;
    private int size;
    private int bitchNum;
    private int dogNum;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDate;
    @ManyToMany(mappedBy = "ownLitters")
    private List<Dog> dogs = new ArrayList<>();

    public Litter(char letter, String name, String breed, String mother, String father, int size, int bitchNum, int dogNum, Date birthDate) {
        this.id = UUID.randomUUID().toString();

        this.letter = letter;
        this.name = name;
        this.breed = breed;
        this.mother = mother;
        this.father = father;
        this.size = size;
        this.bitchNum = bitchNum;
        this.dogNum = dogNum;
        this.birthDate = birthDate;
    }

    public Litter() {
        this.id = UUID.randomUUID().toString();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBitchNum() {
        return bitchNum;
    }

    public void setBitchNum(int bitchNum) {
        this.bitchNum = bitchNum;
    }

    public int getDogNum() {
        return dogNum;
    }

    public void setDogNum(int dogNum) {
        this.dogNum = dogNum;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    @Override
    public String toString() {
        return "Litter{" +
                "id=" + id +
                ", letter=" + letter +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", mother='" + mother + '\'' +
                ", father='" + father + '\'' +
                ", size=" + size +
                ", bitchNum=" + bitchNum +
                ", dogNum=" + dogNum +
                ", birthDate=" + birthDate +
                ", dogs=" + dogs +
                '}';
    }
}
