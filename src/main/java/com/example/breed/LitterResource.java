package com.example.breed;

import com.example.breed.dto.LitterDTO;
import com.example.breed.model.Litter;
import com.example.breed.service.LitterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/litter")
public class LitterResource {
    private final LitterService litterService;

    public LitterResource(LitterService litterService) {
        this.litterService = litterService;
    }

    @GetMapping("/all")
    public List<LitterDTO> getAllLitters () {
        return litterService.findAllLitters().stream().map(litter -> {
            LitterDTO litterDTO = new LitterDTO(litter);
            return  litterDTO;
        }).collect(Collectors.toList());
    }

    @GetMapping("/find/{id}")
    public LitterDTO getLitterById (@PathVariable("id") String id) throws Throwable {
        return new LitterDTO(litterService.findLitterById(id));
    }

    @PostMapping("/add")
    public LitterDTO addLitter(@RequestBody Litter litter) {
        return new LitterDTO(litterService.addLitter(litter));
    }

    @PutMapping("/update")
    public LitterDTO updateLitter(@RequestBody Litter litter) {
        return new LitterDTO(litterService.updateLitter(litter));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLitter(@PathVariable("id") String id) {
        litterService.deleteLitter(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
