package com.example.breed;

import com.example.breed.dto.MedicalExamDTO;
import com.example.breed.model.MedicalExam;
import com.example.breed.model.Training;
import com.example.breed.service.MedicalExamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicalexams")
public class MedicalExamResource {
    private  final MedicalExamService medicalExamService;

    public MedicalExamResource(MedicalExamService medicalExamService) {
        this.medicalExamService = medicalExamService;
    }

    @GetMapping("/all")
    public List<MedicalExamDTO> getAllMedicalExams() {
        return medicalExamService.findAllMedicalExams().stream().map(medicalExam -> {
            MedicalExamDTO medicalExamDTO = new MedicalExamDTO(medicalExam);
            return medicalExamDTO;
        }).collect(Collectors.toList());
    }

    @GetMapping("/find/{id}")
    public MedicalExamDTO getMedicalExamById(@PathVariable("id") String id) throws Throwable {
        return new MedicalExamDTO(medicalExamService.findMedicalLitterById(id));
    }

    @PostMapping("/add")
    public MedicalExamDTO addMedicalExam(@RequestBody MedicalExam medicalExam) {
        return new MedicalExamDTO(medicalExamService.addMedicalExam(medicalExam));
    }

    @PutMapping("/update")
    public MedicalExamDTO updateMedicalExam(@RequestBody MedicalExam medicalExam) {
        return new MedicalExamDTO(medicalExamService.updateMedicalExam(medicalExam));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMedicalExam(@PathVariable("id") String id) {
        medicalExamService.deleteMedicalExam(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
