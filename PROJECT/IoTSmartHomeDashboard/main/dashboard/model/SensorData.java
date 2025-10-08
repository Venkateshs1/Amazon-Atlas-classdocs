package com.iot.dashboard.model;

import java.time.LocalDateTime;

public class SensorData {
    private String deviceId;
    private String sensorType;
    private double value;
    private String unit;
    private LocalDateTime timestamp;

    public SensorData() {}

    public SensorData(String deviceId, String sensorType, double value, String unit) {
        this.deviceId = deviceId;
        this.sensorType = sensorType;
        this.value = value;
        this.unit = unit;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

    public String getSensorType() { return sensorType; }
    public void setSensorType(String sensorType) { this.sensorType = sensorType; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    @Override
    public String toString() {
        return String.format("SensorData{device='%s', type='%s', value=%.2f %s, time=%s}", 
                           deviceId, sensorType, value, unit, timestamp);
    }
}