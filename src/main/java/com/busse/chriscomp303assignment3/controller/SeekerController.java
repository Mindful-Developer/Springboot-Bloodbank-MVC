package com.busse.chriscomp303assignment3.controller;

import com.busse.chriscomp303assignment3.model.Seeker;
import com.busse.chriscomp303assignment3.service.SeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/seekers")
public class SeekerController {
    @Autowired
    private SeekerService seekerService;

    @GetMapping
    public ResponseEntity<List<Seeker>> getAllSeekers() {
        List<Seeker> seekers = seekerService.getAllSeekers();
        return new ResponseEntity<>(seekers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seeker> getSeekerById(@PathVariable Long id) {
        Seeker seeker = seekerService.getSeekerById(id);
        if (seeker != null) {
            return new ResponseEntity<>(seeker, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Seeker> createSeeker(@Valid @RequestBody Seeker seeker) {
        Seeker newSeeker = seekerService.addSeeker(seeker);
        return new ResponseEntity<>(newSeeker, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seeker> updateSeeker(@PathVariable Long id, @Valid @RequestBody Seeker seeker) {
        Seeker updatedSeeker = seekerService.updateSeeker(id, seeker);
        if (updatedSeeker != null) {
            return new ResponseEntity<>(updatedSeeker, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeeker(@PathVariable Long id) {
        if (seekerService.deleteSeeker(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}