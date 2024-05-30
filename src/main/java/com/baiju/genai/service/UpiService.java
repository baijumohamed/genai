package com.baiju.genai.service;

// UpiService.java
import com.baiju.genai.domain.UPI;

import java.util.HashMap;
import java.util.Map;

public class UpiService {
    private Map<String, UPI> upiDatabase = new HashMap<>();

    public void designateUPI(String swapId, String upiCode, String productClassification) {
        UPI upi = new UPI(upiCode, productClassification);
        upiDatabase.put(swapId, upi);
    }

    public UPI getUPI(String swapId) {
        return upiDatabase.get(swapId);
    }

    public void updateDocumentation(String swapId) {
        UPI upi = upiDatabase.get(swapId);
        if (upi != null) {
            // Code to update documentation
            System.out.println("Documentation updated for swapId: " + swapId + " with UPI: " + upi);
        }
    }
}
