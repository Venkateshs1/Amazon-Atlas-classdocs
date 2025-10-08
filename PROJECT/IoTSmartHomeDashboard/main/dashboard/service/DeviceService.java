package com.iot.dashboard.service;

import com.iot.dashboard.database.DynamoDBService;
import com.iot.dashboard.model.Device;
import com.iot.dashboard.model.NetworkTopology;
import com.iot.dashboard.model.SensorData;

import java.util.List;
import java.util.Random;

public class DeviceService {
    private final DynamoDBService dynamoDBService;
    private final NetworkTopology networkTopology;
    private final Random random;

    public DeviceService() {
        this.dynamoDBService = new DynamoDBService();
        this.networkTopology = new NetworkTopology();
        this.random = new Random();
    }

    public void registerDevice(String deviceId, String name, String type, String location) {
        Device device = new Device(deviceId, name, type, location);
        dynamoDBService.saveDevice(device);
        networkTopology.addDevice(device);
        System.out.println("Device registered: " + device);
    }

    public void updateDeviceStatus(String deviceId, String status) {
        Device device = dynamoDBService.getDevice(deviceId);
        if (device != null) {
            device.setStatus(status);
            dynamoDBService.saveDevice(device);
            System.out.println("Device status updated: " + deviceId + " -> " + status);
        } else {
            System.out.println("Device not found: " + deviceId);
        }
    }

    public void controlDevice(String deviceId, String action) {
        Device device = dynamoDBService.getDevice(deviceId);
        if (device != null) {
            String newStatus = action.equalsIgnoreCase("ON") ? "ONLINE" : "OFFLINE";
            updateDeviceStatus(deviceId, newStatus);
            System.out.println("Device " + deviceId + " turned " + action);
        } else {
            System.out.println("Device not found: " + deviceId);
        }
    }

    public void simulateSensorData(String deviceId, String sensorType, String unit) {
        Device device = dynamoDBService.getDevice(deviceId);
        if (device != null && "ONLINE".equals(device.getStatus())) {
            double value = generateSensorValue(sensorType);
            SensorData sensorData = new SensorData(deviceId, sensorType, value, unit);
            dynamoDBService.saveSensorData(sensorData);
            System.out.println("Sensor data recorded: " + sensorData);
        } else {
            System.out.println("Device offline or not found: " + deviceId);
        }
    }

    private double generateSensorValue(String sensorType) {
        return switch (sensorType.toLowerCase()) {
            case "temperature" -> 18 + random.nextDouble() * 15; // 18-33°C
            case "humidity" -> 30 + random.nextDouble() * 40;    // 30-70%
            case "light" -> random.nextDouble() * 1000;          // 0-1000 lux
            case "motion" -> random.nextBoolean() ? 1 : 0;       // 0 or 1
            default -> random.nextDouble() * 100;
        };
    }

    public void connectDevices(String deviceId1, String deviceId2) {
        networkTopology.addConnection(deviceId1, deviceId2);
        System.out.println("Connected devices: " + deviceId1 + " <-> " + deviceId2);
    }

    public List<Device> getAllDevices() {
        return dynamoDBService.getAllDevices();
    }

    public Device getDevice(String deviceId) {
        return dynamoDBService.getDevice(deviceId);
    }

    public NetworkTopology getNetworkTopology() {
        return networkTopology;
    }

    public void close() {
        dynamoDBService.close();
    }
}