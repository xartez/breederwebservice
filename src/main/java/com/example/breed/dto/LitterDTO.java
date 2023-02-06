package com.example.breed.dto;

import com.example.breed.model.Dog;
import com.example.breed.model.Litter;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LitterDTO {
    private char letter;
    private String name;
    private String breed;
    private String mother;
    private String father;
    private int size;
    private int bitchNum;
    private int dogNum;
    private Date birthDate;
    private List<Dog> dogs = new ArrayList<>();

    public LitterDTO(Litter litter) {
        this.letter = litter.getLetter();
        this.name = litter.getName();
        this.breed = litter.getBreed();
        this.mother = litter.getMother();
        this.father = litter.getFather();
        this.size = litter.getSize();
        this.bitchNum = litter.getBitchNum();
        this.dogNum = litter.getDogNum();
        this.birthDate = litter.getBirthDate();
        this.dogs = litter.getDogs();
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
        return "LitterDTO{" +
                "letter=" + letter +
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
