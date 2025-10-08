package com.iot.dashboard;

import com.iot.dashboard.model.Device;
import com.iot.dashboard.service.DeviceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class DeviceStatusTest {
    private DeviceService deviceService;

    @BeforeEach
    void setUp() {
        deviceService = new DeviceService();
    }

    @Test
    @DisplayName("Given a new device, when registered, then it should be offline by default")
    void testNewDeviceDefaultStatus() {
        // Given
        String deviceId = "test-device-1";
        String name = "Test Light";
        String type = "light";
        String location = "Living Room";

        // When
        deviceService.registerDevice(deviceId, name, type, location);
        Device device = deviceService.getDevice(deviceId);

        // Then
        assertNotNull(device);
        assertEquals("OFFLINE", device.getStatus());
        assertEquals(deviceId, device.getDeviceId());
        assertEquals(name, device.getName());
    }

    @Test
    @DisplayName("Given an offline device, when turned on, then status should be online")
    void testDeviceTurnOn() {
        // Given
        String deviceId = "test-device-2";
        deviceService.registerDevice(deviceId, "Test Thermostat", "thermostat", "Bedroom");

        // When
        deviceService.controlDevice(deviceId, "ON");
        Device device = deviceService.getDevice(deviceId);

        // Then
        assertNotNull(device);
        assertEquals("ONLINE", device.getStatus());
    }

    @Test
    @DisplayName("Given an online device, when turned off, then status should be offline")
    void testDeviceTurnOff() {
        // Given
        String deviceId = "test-device-3";
        deviceService.registerDevice(deviceId, "Test Camera", "camera", "Kitchen");
        deviceService.controlDevice(deviceId, "ON");

        // When
        deviceService.controlDevice(deviceId, "OFF");
        Device device = deviceService.getDevice(deviceId);

        // Then
        assertNotNull(device);
        assertEquals("OFFLINE", device.getStatus());
    }

    @Test
    @DisplayName("Given a non-existent device, when controlled, then no exception should be thrown")
    void testControlNonExistentDevice() {
        // Given
        String nonExistentDeviceId = "non-existent-device";

        // When & Then
        assertDoesNotThrow(() -> {
            deviceService.controlDevice(nonExistentDeviceId, "ON");
        });

        Device device = deviceService.getDevice(nonExistentDeviceId);
        assertNull(device);
    }

    @Test
    @DisplayName("Given multiple devices, when listed, then all should be returned")
    void testListMultipleDevices() {
        // Given
        deviceService.registerDevice("device-1", "Light 1", "light", "Room 1");
        deviceService.registerDevice("device-2", "Light 2", "light", "Room 2");
        deviceService.registerDevice("device-3", "Sensor 1", "sensor", "Room 3");

        // When
        var devices = deviceService.getAllDevices();

        // Then
        assertTrue(devices.size() >= 3);
        assertTrue(devices.stream().anyMatch(d -> "device-1".equals(d.getDeviceId())));
        assertTrue(devices.stream().anyMatch(d -> "device-2".equals(d.getDeviceId())));
        assertTrue(devices.stream().anyMatch(d -> "device-3".equals(d.getDeviceId())));
    }
}