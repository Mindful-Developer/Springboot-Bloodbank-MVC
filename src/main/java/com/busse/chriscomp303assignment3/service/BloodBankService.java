package com.busse.chriscomp303assignment3.service;

import com.busse.chriscomp303assignment3.model.BloodBank;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class BloodBankService {
    private static final Map<Long, BloodBank> bankDB = new HashMap<>();
    private static long bankId = 1;

    public List<BloodBank> getAllBloodBanks() {
        return new ArrayList<>(bankDB.values());
    }

    public BloodBank getBloodBankById(Long id) {
        return bankDB.get(id);
    }

    public BloodBank addBloodBank(BloodBank bloodBank) {
        bloodBank.setId(bankId++);
        bankDB.put(bloodBank.getId(), bloodBank);
        return bloodBank;
    }

    public BloodBank updateBloodBank(Long id, BloodBank bloodBank) {
        if (bankDB.containsKey(id)) {
            bloodBank.setId(id);
            bankDB.put(id, bloodBank);
            return bloodBank;
        }
        return null;
    }

    public boolean deleteBloodBank(Long id) {
        if (bankDB.containsKey(id)) {
            bankDB.remove(id);
            return true;
        }
        return false;
    }
}