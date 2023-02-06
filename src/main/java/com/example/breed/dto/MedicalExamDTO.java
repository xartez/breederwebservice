package com.example.breed.dto;

import com.example.breed.model.Dog;
import com.example.breed.model.MedicalExam;

import javax.persistence.ManyToOne;

public class MedicalExamDTO {
    private String medicalExamination;
    private String scanUrl;
    private Dog dog;

    public MedicalExamDTO(MedicalExam medicalExam) {
        this.medicalExamination = medicalExam.getMedicalExamination();
        this.scanUrl = medicalExam.getScanUrl();
        this.dog = medicalExam.getDog();
    }

    public String getMedicalExamination() {
        return medicalExamination;
    }

    public void setMedicalExamination(String medicalExamination) {
        this.medicalExamination = medicalExamination;
    }

    public String getScanUrl() {
        return scanUrl;
    }

    public void setScanUrl(String scanUrl) {
        this.scanUrl = scanUrl;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "MedicalExamDTO{" +
                "medicalExamination='" + medicalExamination + '\'' +
                ", scanUrl='" + scanUrl + '\'' +
                ", dog=" + dog +
                '}';
    }
}
