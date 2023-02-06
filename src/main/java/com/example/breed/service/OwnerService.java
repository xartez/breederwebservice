package com.example.breed.service;

import com.example.breed.exceptions.OwnerNotFoundException;
import com.example.breed.model.Owner;
import com.example.breed.repo.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OwnerService {
    private final OwnerRepo ownerRepo;

    @Autowired
    public OwnerService(OwnerRepo ownerRepo) {
        this.ownerRepo = ownerRepo;
    }

    public Owner addOwner(Owner owner) {
        owner.setId(UUID.randomUUID().toString());
        return ownerRepo.save(owner);
    }

    public List<Owner> findAllOwners() {
        return  ownerRepo.findAll();
    }

    public Owner updateOwner(Owner owner) {
        return ownerRepo.save(owner);
    }

    public Owner findOwnerById(String id) throws Throwable {
        return ownerRepo.findOwnerById(id)
                .orElseThrow(() -> new OwnerNotFoundException("Owner by id " + id + " was not found"));
    }

    public void deleteOwner(String id) { ownerRepo.deleteOwnerById(id); }

/*    public List<Dog> getDogListByBreed(String breed) {

    }*/
}

