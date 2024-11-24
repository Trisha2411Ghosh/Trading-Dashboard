package com.CME.backend.util;

public class PerformanceMetricsDTO {
    private double writeSpeed;
    private long latency;

    public PerformanceMetricsDTO(double writeSpeed, long latency) {
        this.writeSpeed = writeSpeed;
        this.latency = latency;
    }

    // Getters and setters
    public double getWriteSpeed() { return writeSpeed; }
    public void setWriteSpeed(double writeSpeed) { this.writeSpeed = writeSpeed; }

    public long getLatency() { return latency; }
    public void setLatency(long latency) { this.latency = latency; }
}