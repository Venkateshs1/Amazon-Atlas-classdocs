package com.iot.dashboard;

import com.iot.dashboard.model.Device;
import com.iot.dashboard.network.SocketSimulator;
import com.iot.dashboard.service.DeviceService;

import java.util.List;
import java.util.Scanner;

public class IoTDashboard {
    private final DeviceService deviceService;
    private final SocketSimulator socketSimulator;
    private final Scanner scanner;

    public IoTDashboard() {
        try {
            this.deviceService = new DeviceService();
            this.socketSimulator = new SocketSimulator();
            this.scanner = new Scanner(System.in);
        } catch (Exception e) {
            System.err.println("Failed to initialize IoT Dashboard: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void start() {
        try {
            System.out.println("=== IoT Smart Home Dashboard ===");
            System.out.println("Starting IoT Gateway...");
            socketSimulator.startGateway(9999);

            boolean running = true;
            while (running) {
                try {
                    displayMenu();
                    int choice = getChoice();

                    switch (choice) {
                        case 1 -> registerDevice();
                        case 2 -> listDevices();
                        case 3 -> controlDevice();
                        case 4 -> monitorDevice();
                        case 5 -> simulateSensorData();
                        case 6 -> connectDevices();
                        case 7 -> showNetworkTopology();
                        case 8 -> {
                            running = false;
                            shutdown();
                        }
                        default -> System.out.println("Invalid choice. Please try again.");
                    }
                } catch (Exception e) {
                    System.err.println("Error processing menu option: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Fatal error in IoT Dashboard: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void displayMenu() {
        System.out.println("\n=== IoT Dashboard Menu ===");
        System.out.println("1. Register Device");
        System.out.println("2. List All Devices");
        System.out.println("3. Control Device");
        System.out.println("4. Monitor Device Status");
        System.out.println("5. Simulate Sensor Data");
        System.out.println("6. Connect Devices");
        System.out.println("7. Show Network Topology");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void registerDevice() {
        try {
            System.out.print("Enter Device ID: ");
            String deviceId = scanner.nextLine();
            System.out.print("Enter Device Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Device Type (light/thermostat/camera/sensor): ");
            String type = scanner.nextLine();
            System.out.print("Enter Location: ");
            String location = scanner.nextLine();

            deviceService.registerDevice(deviceId, name, type, location);
        } catch (Exception e) {
            System.err.println("Error registering device: " + e.getMessage());
        }
    }

    private void listDevices() {
        List<Device> devices = deviceService.getAllDevices();
        if (devices.isEmpty()) {
            System.out.println("No devices registered.");
        } else {
            System.out.println("\n=== Registered Devices ===");
            for (Device device : devices) {
                System.out.println(device);
            }
        }
    }

    private void controlDevice() {
        System.out.print("Enter Device ID: ");
        String deviceId = scanner.nextLine();
        System.out.print("Enter Action (ON/OFF): ");
        String action = scanner.nextLine();

        deviceService.controlDevice(deviceId, action);
    }

    private void monitorDevice() {
        System.out.print("Enter Device ID: ");
        String deviceId = scanner.nextLine();

        Device device = deviceService.getDevice(deviceId);
        if (device != null) {
            System.out.println("Device Status: " + device);
        } else {
            System.out.println("Device not found: " + deviceId);
        }
    }

    private void simulateSensorData() {
        System.out.print("Enter Device ID: ");
        String deviceId = scanner.nextLine();
        System.out.print("Enter Sensor Type (temperature/humidity/light/motion): ");
        String sensorType = scanner.nextLine();
        System.out.print("Enter Unit (°C/%/lux/boolean): ");
        String unit = scanner.nextLine();

        deviceService.simulateSensorData(deviceId, sensorType, unit);
    }

    private void connectDevices() {
        System.out.print("Enter First Device ID: ");
        String deviceId1 = scanner.nextLine();
        System.out.print("Enter Second Device ID: ");
        String deviceId2 = scanner.nextLine();

        deviceService.connectDevices(deviceId1, deviceId2);
    }

    private void showNetworkTopology() {
        System.out.println("\n=== Network Topology ===");
        var topology = deviceService.getNetworkTopology();
        var devices = topology.getDevices();
        var connections = topology.getAdjacencyList();

        if (devices.isEmpty()) {
            System.out.println("No devices in network.");
            return;
        }

        for (String deviceId : devices.keySet()) {
            System.out.print(deviceId + " -> ");
            var connected = connections.get(deviceId);
            if (connected != null && !connected.isEmpty()) {
                System.out.println(connected);
            } else {
                System.out.println("No connections");
            }
        }
    }



    private void shutdown() {
        System.out.println("Shutting down IoT Dashboard...");
        socketSimulator.stop();
        deviceService.close();
        scanner.close();
        System.out.println("Dashboard stopped.");
    }

    public static void main(String[] args) {
        new IoTDashboard().start();
    }
}