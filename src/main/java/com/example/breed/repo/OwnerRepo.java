package com.example.breed.repo;

import com.example.breed.model.Litter;
import com.example.breed.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OwnerRepo extends JpaRepository<Owner, String> {
    void deleteOwnerById(String id);

    Optional<Owner> findOwnerById(String id);
}
