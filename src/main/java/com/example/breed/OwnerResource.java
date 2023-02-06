package com.example.breed;

import com.example.breed.dto.OwnerDTO;
import com.example.breed.model.Owner;
import com.example.breed.service.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/owner")
public class OwnerResource {
    private final OwnerService ownerService;

    public OwnerResource(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/all")
    public List<OwnerDTO> getAllOwners () {
        return ownerService.findAllOwners().stream().map(owner -> {
                OwnerDTO ownerDTO = new OwnerDTO(owner);
                return ownerDTO;
        }).collect(Collectors.toList());
    }

    @GetMapping("/find/{id}")
    public OwnerDTO getOwnerById (@PathVariable("id") String id) throws Throwable {
        return new OwnerDTO(ownerService.findOwnerById(id));
    }

    @PostMapping("/add")
    public OwnerDTO addOwner(@RequestBody Owner owner) {
       OwnerDTO ownerDTO = new OwnerDTO(ownerService.addOwner(owner));
        System.out.println(ownerDTO);
        return ownerDTO;
    }

    @PutMapping("/update")
    public OwnerDTO updateOwner(@RequestBody Owner owner) {
        return new OwnerDTO(ownerService.updateOwner(owner));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOwner(@PathVariable("id") String id) {
        ownerService.deleteOwner(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
