package com.example.breed.repo;

import com.example.breed.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TitleRepo extends JpaRepository<Title, String> {
    void deleteTitleById(String id);

    Optional<Title> findTitleById(String id);
}
