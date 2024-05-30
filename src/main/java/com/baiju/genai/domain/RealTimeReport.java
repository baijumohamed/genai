package com.baiju.genai.domain;

public class RealTimeReport {
    private String swapId;
    private String reportData;

    public RealTimeReport(String swapId, String reportData) {
        this.swapId = swapId;
        this.reportData = reportData;
    }

    public String getSwapId() {
        return swapId;
    }

    public String getReportData() {
        return reportData;
    }

    @Override
    public String toString() {
        return "RealTimeReport{" +
                "swapId='" + swapId + '\'' +
                ", reportData='" + reportData + '\'' +
                '}';
    }
}