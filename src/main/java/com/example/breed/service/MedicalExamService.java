package com.example.breed.service;

import com.example.breed.exceptions.MedicalExamNotFoundException;
import com.example.breed.model.MedicalExam;
import com.example.breed.repo.MedicalExamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MedicalExamService {
    private final MedicalExamRepo medicalExamRepo;

    @Autowired
    public MedicalExamService(MedicalExamRepo medicalExamRepo) { this.medicalExamRepo = medicalExamRepo;}

    public MedicalExam addMedicalExam(MedicalExam medicalExam) { return medicalExamRepo.save(medicalExam);}

    public List<MedicalExam> findAllMedicalExams() {return  medicalExamRepo.findAll();}

    public MedicalExam updateMedicalExam(MedicalExam medicalExam) { return medicalExamRepo.save(medicalExam);}

    public MedicalExam findMedicalLitterById(String id) throws Throwable {
        return medicalExamRepo.findMedicalExamById(id)
                .orElseThrow(() -> new MedicalExamNotFoundException("Medical exam by id  " + id + " was not found"));
    }

    public void deleteMedicalExam(String id) { medicalExamRepo.deleteMedicalExamById(id);}

}
