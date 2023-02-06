package com.example.breed.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Entity
@Table(name = "DOG", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")
})
public class Dog implements Serializable {
    @Id
    @Column(updatable = false, nullable = false, unique = true, length = 36)
    private String id;
    private String profileImageUrl;
    private String breed;
    private String name;
    private String origin;
    private int age;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;
    private Sex sex;
    public enum Sex {
        M, F;
    }
    @OneToMany(
            mappedBy = "dog",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Title> titles;
    @OneToMany(mappedBy = "dog")
    private List<MedicalExam> medicalExams;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="litter_id")
    private Litter originLitter;
    @ManyToMany
    @JoinTable(
            name = "own_litters",
            joinColumns = @JoinColumn(name = "dog_id"),
            inverseJoinColumns = @JoinColumn(name = "litter_id"))
    private List<Litter> ownLitters;
    private String kennel;
    @ManyToMany
    @JoinTable(
            name = "trainings",
            joinColumns = @JoinColumn(name = "dog_id"),
            inverseJoinColumns = @JoinColumn(name = "taining_id"))
    private List<Training> trainings;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    private Reservation reservation;

    public Dog(String profileImageUrl, String breed, String name, String origin, LocalDate birthDate, Sex sex, List<Title> titles, List<MedicalExam> medicalExams, Owner owner, Litter originLitter, ArrayList<Litter> ownLitters, String kennel, ArrayList<Training> trainings) {
        this.id = UUID.randomUUID().toString();
        this.profileImageUrl = profileImageUrl;
        this.breed = breed;
        this.name = name;
        this.origin = origin;
        this.birthDate = birthDate;
        this.sex = sex;
        this.titles = titles;
        this.medicalExams = medicalExams;
        this.owner = owner;
        this.originLitter = originLitter;
        this.ownLitters = ownLitters;
        this.kennel = kennel;
        this.trainings = trainings;
        LocalDate currentDate = LocalDate.now();
        this.age = calculateAge(this.birthDate, currentDate);
        this.reservation = null;
    }

    public Dog() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
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
        return sex.name();
    }

    public void setSex(Sex sex) {
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
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

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                ", breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", sex=" + sex +
                ", titles=" + titles +
                ", medicalExams=" + medicalExams +
                ", owner=" + owner +
                ", originLitter=" + originLitter +
                ", ownLitters=" + ownLitters +
                ", kennel='" + kennel + '\'' +
                ", trainings=" + trainings +
                '}';
    }


    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
}


