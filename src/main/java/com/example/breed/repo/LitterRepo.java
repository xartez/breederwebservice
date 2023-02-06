package com.example.breed.repo;

import com.example.breed.model.Dog;
import com.example.breed.model.Litter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LitterRepo extends JpaRepository<Litter, String> {
    void deleteLitterById(String id);

    Optional<Litter> findLitterById(String id);
}
