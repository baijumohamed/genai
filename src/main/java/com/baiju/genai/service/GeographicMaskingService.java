package com.baiju.genai.service;

import com.baiju.genai.domain.UPI;

import java.util.HashMap;
import java.util.Map;

public class GeographicMaskingService {
    private Map<String, UPI> upiDatabase = new HashMap<>();
    private Map<String, String> geographicData = new HashMap<>();

    public void designateUPI(String swapId, String upiCode, String productClassification) {
        UPI upi = new UPI(upiCode, productClassification);
        upiDatabase.put(swapId, upi);
    }

    public void applyGeographicMasking(String swapId, String geographicInfo) {
        String maskedData = maskGeographicData(geographicInfo);
        geographicData.put(swapId, maskedData);
    }

    private String maskGeographicData(String geographicInfo) {
        // Implement masking logic here
        return "MASKED_" + geographicInfo;
    }

    public String getMaskedGeographicData(String swapId) {
        return geographicData.get(swapId);
    }
}