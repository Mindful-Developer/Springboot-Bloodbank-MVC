package com.busse.chriscomp303assignment3.controller;

import com.busse.chriscomp303assignment3.model.BloodBank;
import com.busse.chriscomp303assignment3.service.BloodBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/bloodbanks")
public class BloodBankController {
    @Autowired
    private BloodBankService bloodBankService;

    @GetMapping
    public ResponseEntity<List<BloodBank>> getAllBloodBanks() {
        List<BloodBank> bloodBanks = bloodBankService.getAllBloodBanks();
        return new ResponseEntity<>(bloodBanks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BloodBank> getBloodBankById(@PathVariable Long id) {
        BloodBank bloodBank = bloodBankService.getBloodBankById(id);
        if (bloodBank != null) {
            return new ResponseEntity<>(bloodBank, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<BloodBank> createBloodBank(@Valid @RequestBody BloodBank bloodBank) {
        BloodBank newBloodBank = bloodBankService.addBloodBank(bloodBank);
        return new ResponseEntity<>(newBloodBank, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BloodBank> updateBloodBank(@PathVariable Long id, @Valid @RequestBody BloodBank bloodBank) {
        BloodBank updatedBloodBank = bloodBankService.updateBloodBank(id, bloodBank);
        if (updatedBloodBank != null) {
            return new ResponseEntity<>(updatedBloodBank, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBloodBank(@PathVariable Long id) {
        if (bloodBankService.deleteBloodBank(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}