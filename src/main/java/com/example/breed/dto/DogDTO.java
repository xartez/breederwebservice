package com.example.breed.dto;

import com.example.breed.model.*;
import jdk.jfr.DataAmount;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class DogDTO {
    private String breed;
    private String name;
    private String origin;
    private int age;
    private LocalDate birthDate;
    private String sex;
    private List<Title> titles;
    private List<MedicalExam> medicalExams;
    private Litter originLitter;
    private List<Litter> ownLitters;
    private String kennel;
    private List<Training> trainings;
    private Owner owner;

    public DogDTO(Dog dog) {
        this.breed = dog.getBreed();
        this.name = dog.getName();
        this.origin = dog.getOrigin();
        this.age = dog.getAge();
        this.birthDate = dog.getBirthDate();
        this.sex = dog.getSex();
        this.titles = dog.getTitles();
        this.medicalExams = dog.getMedicalExams();
        this.originLitter = dog.getOriginLitter();
        this.ownLitters = dog.getOwnLitters();
        this.kennel = dog.getKennel();
        this.trainings = dog.getTrainings();
        this.owner = dog.getOwner();
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Title> getTitles() {
        return titles;
    }

    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }

    public List<MedicalExam> getMedicalExams() {
        return medicalExams;
    }

    public void setMedicalExams(List<MedicalExam> medicalExams) {
        this.medicalExams = medicalExams;
    }

    public Litter getOriginLitter() {
        return originLitter;
    }

    public void setOriginLitter(Litter originLitter) {
        this.originLitter = originLitter;
    }

    public List<Litter> getOwnLitters() {
        return ownLitters;
    }

    public void setOwnLitters(List<Litter> ownLitters) {
        this.ownLitters = ownLitters;
    }

    public String getKennel() {
        return kennel;
    }

    public void setKennel(String kennel) {
        this.kennel = kennel;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }

    @Override
    public String toString() {
        return "DogDTO{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", sex=" + sex +
                ", titles=" + titles +
                ", medicalExams=" + medicalExams +
                ", originLitter=" + originLitter +
                ", ownLitters=" + ownLitters +
                ", kennel='" + kennel + '\'' +
                ", trainings=" + trainings +
                ", owner=" + owner +
                '}';
    }
}
