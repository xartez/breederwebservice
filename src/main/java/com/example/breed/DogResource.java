package com.example.breed;

import com.example.breed.dto.DogDTO;
import com.example.breed.model.Dog;
import com.example.breed.service.DogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dog")
public class DogResource {
    private final DogService dogService;

    public DogResource(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/all")
    List<DogDTO> getAllDogs () {
        return dogService.findAllDogs().stream().map(dog -> {
            DogDTO dogDTO = new DogDTO(dog);
            return dogDTO;
        }).collect(Collectors.toList());
    }

    @GetMapping("/find/{id}")
    public DogDTO getDogById (@PathVariable("id") String id) throws Throwable {
        return new DogDTO(dogService.findDogById(id));
    }

    @PostMapping("/add")
    public DogDTO addDog(@RequestBody Dog dog) {
        return new DogDTO(dogService.addDog(dog));
    }

    @PutMapping("/update")
    public DogDTO updateDog(@RequestBody Dog dog) {
        return new DogDTO(dogService.updateDog(dog));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDog(@PathVariable("id") String id) {
        dogService.deleteDog(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
