package com.example.breed.service;

import com.example.breed.exceptions.LitterNotFoundException;
import com.example.breed.model.Dog;
import com.example.breed.model.Litter;
import com.example.breed.repo.LitterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LitterService {
    private final LitterRepo litterRepo;

    @Autowired
    public LitterService(LitterRepo litterRepo) {
        this.litterRepo = litterRepo;
    }

    public Litter addLitter(Litter litter) {
        return litterRepo.save(litter);
    }

    public List<Litter> findAllLitters() {
        return  litterRepo.findAll();
    }

    public Litter updateLitter(Litter litter) {
        return litterRepo.save(litter);
    }

    public Litter findLitterById(String id) throws Throwable {
        return litterRepo.findLitterById(id)
                .orElseThrow(() -> new LitterNotFoundException("Litter by id " + id + " was not found"));
    }

    public void deleteLitter(String id) { litterRepo.deleteLitterById(id); }

/*    public List<Dog> getDogListByBreed(String breed) {

    }*/
}
