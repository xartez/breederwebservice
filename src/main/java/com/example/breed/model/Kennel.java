package com.example.breed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Kennel {
    @Id
    @Column(updatable = false, nullable = false, unique = true, length = 36)
    private String id;
    private int bitchNum;
    private int dogNum;
    private int litterNum;
    private int plannedLitterNum;
    private String breed;

    public Kennel() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getLitterNum() {
        return litterNum;
    }

    public void setLitterNum(int litterNum) {
        this.litterNum = litterNum;
    }

    public int getPlannedLitterNum() {
        return plannedLitterNum;
    }

    public void setPlannedLitterNum(int plannedLitterNum) {
        this.plannedLitterNum = plannedLitterNum;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}

