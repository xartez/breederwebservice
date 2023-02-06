package com.example.breed.dto;

import com.example.breed.model.Kennel;

public class KennelDTO {
    private int bitchNum;
    private int dogNum;
    private int litterNum;
    private int plannedLitterNum;
    private String breed;

    public KennelDTO(Kennel kennel) {
        this.bitchNum = kennel.getBitchNum();
        this.dogNum = kennel.getDogNum();
        this.litterNum = kennel.getLitterNum();
        this.plannedLitterNum = kennel.getPlannedLitterNum();
        this.breed = kennel.getBreed();
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

    @Override
    public String toString() {
        return "KennelDTO{" +
                "bitchNum=" + bitchNum +
                ", dogNum=" + dogNum +
                ", litterNum=" + litterNum +
                ", plannedLitterNum=" + plannedLitterNum +
                ", breed='" + breed + '\'' +
                '}';
    }
}
