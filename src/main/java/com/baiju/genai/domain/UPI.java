package com.baiju.genai.domain;

public class UPI {
    private String upiCode;
    private String productClassification;

    public UPI(String upiCode, String productClassification) {
        this.upiCode = upiCode;
        this.productClassification = productClassification;
    }

    public String getUpiCode() {
        return upiCode;
    }

    public String getProductClassification() {
        return productClassification;
    }

    @Override
    public String toString() {
        return "UPI{" +
                "upiCode='" + upiCode + '\'' +
                ", productClassification='" + productClassification + '\'' +
                '}';
    }
}

