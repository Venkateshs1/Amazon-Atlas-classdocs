package com.iot.dashboard.model;

import java.time.LocalDateTime;
import java.util.Map;

public class Device {
    private String deviceId;
    private String name;
    private String type;
    private String status;
    private String location;
    private LocalDateTime lastUpdated;
    private Map<String, Object> properties;

    public Device() {}

    public Device(String deviceId, String name, String type, String location) {
        this.deviceId = deviceId;
        this.name = name;
        this.type = type;
        this.location = location;
        this.status = "OFFLINE";
        this.lastUpdated = LocalDateTime.now();
    }

    // Getters and Setters
    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getStatus() { return status; }
    public void setStatus(String status) { 
        this.status = status;
        this.lastUpdated = LocalDateTime.now();
    }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }

    public Map<String, Object> getProperties() { return properties; }
    public void setProperties(Map<String, Object> properties) { this.properties = properties; }

    @Override
    public String toString() {
        return String.format("Device{id='%s', name='%s', type='%s', status='%s', location='%s'}", 
                           deviceId, name, type, status, location);
    }
}