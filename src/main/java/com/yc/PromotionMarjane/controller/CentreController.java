package com.yc.PromotionMarjane.controller;

import com.yc.PromotionMarjane.model.Centre;
import com.yc.PromotionMarjane.services.CentreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/center")
public class CentreController {
    private final CentreService service;

    @PostMapping
    public ResponseEntity<Centre> createCentre(@RequestBody Centre centre) {
        Centre savedCentre = service.saveCentre(centre);
        return new ResponseEntity<>(savedCentre, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Centre>> getAllCentres() {
        List<Centre> centres = service.getAllCentres();
        return new ResponseEntity<>(centres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Centre> getCentreById(@PathVariable UUID id) {
        return service.getCentreById(id)
                .map(centre -> new ResponseEntity<>(centre, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Centre> updateCentre(@PathVariable UUID id, @RequestBody Centre centre) {
        if (service.getCentreById(id).isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        centre.setId(id);
        Centre updatedCentre = service.updateCentre(centre);
        return new ResponseEntity<>(updatedCentre, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCentre(@PathVariable UUID id) {
        if (service.getCentreById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        service.deleteCentre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}