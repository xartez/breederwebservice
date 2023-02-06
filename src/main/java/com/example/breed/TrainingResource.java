package com.example.breed;

import com.example.breed.dto.TrainingDTO;
import com.example.breed.model.Training;
import com.example.breed.service.TrainingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/training")
public class TrainingResource {
    private final TrainingService trainingService;

    public TrainingResource(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping("/all")
    public List<TrainingDTO> getAllTrainings () {
        return trainingService.findAllTrainings().stream().map(training -> {
            TrainingDTO trainingDTO = new TrainingDTO(training);
            return  trainingDTO;
        }).collect(Collectors.toList());
    }

    @GetMapping("/find/{id}")
    public TrainingDTO getTrainingById (@PathVariable("id") String id) throws Throwable {
        return new TrainingDTO(trainingService.findTrainingById(id));
    }

    @PostMapping("/add")
    public TrainingDTO addTraining(@RequestBody Training training) {
        return new TrainingDTO(trainingService.addTraining(training));
    }

    @PutMapping("/update")
    public TrainingDTO updateTraining(@RequestBody Training training) {
        return new TrainingDTO(trainingService.updateTraining(training));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTraining(@PathVariable("id") String id) {
        trainingService.deleteTraining(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
