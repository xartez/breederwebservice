package com.example.breed;

import com.example.breed.dto.TitleDTO;
import com.example.breed.model.Title;
import com.example.breed.service.TitleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/title")
public class TitleResource {
    private final TitleService titleService;

    public TitleResource(TitleService titleService) {
        this.titleService = titleService;
    }

    @GetMapping("/all")
    public List<TitleDTO> getAllTitles() {
        return  titleService.findAllTitles().stream().map(title -> {
            TitleDTO titleDTO = new TitleDTO(title);
            return titleDTO;
        }).collect(Collectors.toList());
    }

    @GetMapping("/find/{id}")
    public TitleDTO getTitleById (@PathVariable("id") String id) throws Throwable {
        return new TitleDTO(titleService.findTitleById(id));
    }

    @PostMapping("/add")
    public TitleDTO addTitle(@RequestBody Title title) {
        return new TitleDTO(titleService.addTitle(title));
    }

    @PutMapping("/update")
    public TitleDTO updateTitle(@RequestBody Title title) {
        return new TitleDTO(titleService.updateTitle(title));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTitle(@PathVariable("id") String id) {
        titleService.deleteTitle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
