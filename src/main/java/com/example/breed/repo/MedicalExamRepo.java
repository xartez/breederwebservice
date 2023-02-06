package com.example.breed.repo;

import com.example.breed.model.Litter;
import com.example.breed.model.MedicalExam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MedicalExamRepo extends JpaRepository<MedicalExam, String> {
    void deleteMedicalExamById(String id);

    Optional<MedicalExam> findMedicalExamById(String id);
}
