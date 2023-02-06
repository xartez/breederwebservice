package com.example.breed.repo;

import com.example.breed.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DogRepo extends JpaRepository<Dog, String> {
    void deleteDogById(String id);

    Optional<Dog> findDogById(String id);
}
