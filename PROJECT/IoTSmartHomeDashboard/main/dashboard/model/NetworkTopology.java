package com.iot.dashboard.model;

import java.util.*;

public class NetworkTopology {
    private Map<String, Set<String>> adjacencyList;
    private Map<String, Device> devices;

    public NetworkTopology() {
        this.adjacencyList = new HashMap<>();
        this.devices = new HashMap<>();
    }

    public void addDevice(Device device) {
        devices.put(device.getDeviceId(), device);
        adjacencyList.putIfAbsent(device.getDeviceId(), new HashSet<>());
    }

    public void addConnection(String deviceId1, String deviceId2) {
        adjacencyList.computeIfAbsent(deviceId1, k -> new HashSet<>()).add(deviceId2);
        adjacencyList.computeIfAbsent(deviceId2, k -> new HashSet<>()).add(deviceId1);
    }

    public Set<String> getConnectedDevices(String deviceId) {
        return adjacencyList.getOrDefault(deviceId, new HashSet<>());
    }

    public List<String> findPath(String start, String end) {
        if (!devices.containsKey(start) || !devices.containsKey(end)) {
            return new ArrayList<>();
        }

        Queue<String> queue = new LinkedList<>();
        Map<String, String> parent = new HashMap<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);
        parent.put(start, null);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(end)) {
                return reconstructPath(parent, start, end);
            }

            for (String neighbor : adjacencyList.getOrDefault(current, new HashSet<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<>();
    }

    private List<String> reconstructPath(Map<String, String> parent, String start, String end) {
        List<String> path = new ArrayList<>();
        String current = end;
        while (current != null) {
            path.add(current);
            current = parent.get(current);
        }
        Collections.reverse(path);
        return path;
    }

    public Map<String, Device> getDevices() { return devices; }
    public Map<String, Set<String>> getAdjacencyList() { return adjacencyList; }
}