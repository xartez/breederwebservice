package com.example.breed.service;

import com.example.breed.exceptions.ReservationNotFoundException;
import com.example.breed.model.Training;
import com.example.breed.repo.TrainingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TrainingService {
    private final TrainingRepo trainingRepo;

    @Autowired
    public TrainingService(TrainingRepo trainingRepo) {
        this.trainingRepo = trainingRepo;
    }

    public Training addTraining(Training training) {
        return trainingRepo.save(training);
    }

    public List<Training> findAllTrainings() {
        return trainingRepo.findAll();
    }

    public Training updateTraining(Training training) {
        return trainingRepo.save(training);
    }

    public Training findTrainingById(String id) throws Throwable {
        return trainingRepo.findTrainingById(id)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation with id " + id + "was not found"));
    }

    public void deleteTraining(String id) {
        trainingRepo.deleteTrainingById(id);
    }
}
