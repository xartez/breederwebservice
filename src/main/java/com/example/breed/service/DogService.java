package com.example.breed.service;

import com.example.breed.exceptions.DogNotFoundException;
import com.example.breed.model.Dog;
import com.example.breed.repo.DogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DogService {
    private final DogRepo dogRepo;

    @Autowired
    public DogService(DogRepo dogRepo) {
        this.dogRepo = dogRepo;
    }

    public Dog addDog(Dog dog) {
        return dogRepo.save(dog);
    }

    public List<Dog> findAllDogs() {
        return  dogRepo.findAll();
    }

    public Dog updateDog(Dog dog) {
        return dogRepo.save(dog);
    }

    public Dog findDogById(String id) throws Throwable {
        return dogRepo.findDogById(id)
                .orElseThrow(() -> new DogNotFoundException("Dog by id " + id + " was not found"));
    }

    public void deleteDog(String id) {
        dogRepo.deleteDogById(id);
    }
/*    public List<Dog> getDogListByBreed(String breed) {

    }
    public List<Dog> getDogListByMother() {}
    public List<Dog> getDogListByFather() {}
    public List<Dog> getDogListBySex() {}
    public List<Dog> getDogListByLitter() {}*/

}
