package com.example.breed.service;

import com.example.breed.exceptions.TitleNotFoundException;
import com.example.breed.model.Title;
import com.example.breed.repo.TitleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleService {
    private final TitleRepo titleRepo;

    @Autowired
    public TitleService(TitleRepo titleRepo) {
        this.titleRepo = titleRepo;
    }

    public Title addTitle(Title title) {
        return titleRepo.save(title);
    }

    public List<Title> findAllTitles() {
        return titleRepo.findAll();
    }

    public Title updateTitle(Title title) {
        return  titleRepo.save(title);
    }

    public Title findTitleById(String id) throws  Throwable {
        return titleRepo.findTitleById(id)
                .orElseThrow(() -> new TitleNotFoundException("Title with id " + id + " was not found"));
    }

    public void deleteTitle(String id) {
        titleRepo.deleteTitleById(id);
    }
}
