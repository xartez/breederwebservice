package com.example.breed.repo;

import com.example.breed.model.Litter;
import com.example.breed.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TrainingRepo extends JpaRepository<Training, String> {
    void deleteTrainingById(String id);

    Optional<Training> findTrainingById(String id);
}
