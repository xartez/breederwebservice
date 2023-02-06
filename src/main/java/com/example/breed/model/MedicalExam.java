package com.example.breed.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

@Entity
public class MedicalExam implements Serializable {
    @Id
    @Column(updatable = false, nullable = false, unique = true, length = 36)
    private String id;
    private String medicalExamination;
    private String scanUrl;
    @ManyToOne(fetch = FetchType.LAZY)
    private Dog dog;

    public MedicalExam(String medicalExamination, String scanUrl) {
        this.id = UUID.randomUUID().toString();
        this.medicalExamination = medicalExamination;
        this.scanUrl = scanUrl;
    }

    public MedicalExam() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "MedicalExam{" +
                "id=" + id +
                ", medicalExamination='" + medicalExamination + '\'' +
                ", scanUrl='" + scanUrl + '\'' +
                ", dog=" + dog +
                '}';
    }
}
