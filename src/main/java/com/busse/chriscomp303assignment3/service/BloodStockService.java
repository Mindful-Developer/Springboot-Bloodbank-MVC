package com.busse.chriscomp303assignment3.service;

import com.busse.chriscomp303assignment3.model.BloodStock;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class BloodStockService {
    private static final Map<Long, BloodStock> stockDB = new HashMap<>();
    private static long stockId = 1;

    public List<BloodStock> getAllBloodStocks() {
        return new ArrayList<>(stockDB.values());
    }

    public BloodStock getBloodStockById(Long id) {
        return stockDB.get(id);
    }

    public BloodStock addBloodStock(BloodStock bloodStock) {
        bloodStock.setId(stockId++);
        stockDB.put(bloodStock.getId(), bloodStock);
        return bloodStock;
    }

    public BloodStock updateBloodStock(Long id, BloodStock bloodStock) {
        if (stockDB.containsKey(id)) {
            bloodStock.setId(id);
            stockDB.put(id, bloodStock);
            return bloodStock;
        }
        return null;
    }

    public boolean deleteBloodStock(Long id) {
        if (stockDB.containsKey(id)) {
            stockDB.remove(id);
            return true;
        }
        return false;
    }
}