package com.busse.chriscomp303assignment3.controller;

import com.busse.chriscomp303assignment3.model.BloodStock;
import com.busse.chriscomp303assignment3.service.BloodStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/bloodstocks")
public class BloodStockController {
    @Autowired
    private BloodStockService bloodStockService;

    @GetMapping
    public ResponseEntity<List<BloodStock>> getAllBloodStocks() {
        List<BloodStock> bloodStocks = bloodStockService.getAllBloodStocks();
        return new ResponseEntity<>(bloodStocks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BloodStock> getBloodStockById(@PathVariable Long id) {
        BloodStock bloodStock = bloodStockService.getBloodStockById(id);
        if (bloodStock != null) {
            return new ResponseEntity<>(bloodStock, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<BloodStock> createBloodStock(@Valid @RequestBody BloodStock bloodStock) {
        BloodStock newBloodStock = bloodStockService.addBloodStock(bloodStock);
        return new ResponseEntity<>(newBloodStock, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BloodStock> updateBloodStock(@PathVariable Long id, @Valid @RequestBody BloodStock bloodStock) {
        BloodStock updatedBloodStock = bloodStockService.updateBloodStock(id, bloodStock);
        if (updatedBloodStock != null) {
            return new ResponseEntity<>(updatedBloodStock, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBloodStock(@PathVariable Long id) {
        if (bloodStockService.deleteBloodStock(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}