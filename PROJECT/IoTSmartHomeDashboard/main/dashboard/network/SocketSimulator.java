package com.iot.dashboard.network;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketSimulator {
    private ServerSocket serverSocket;
    private ExecutorService executor;
    private boolean running;

    public SocketSimulator() {
        this.executor = Executors.newFixedThreadPool(10);
    }

    public void startGateway(int port) {
        try {
            serverSocket = new ServerSocket(port);
            running = true;
            System.out.println("IoT Gateway started on port " + port);

            executor.submit(() -> {
                while (running) {
                    try {
                        Socket clientSocket = serverSocket.accept();
                        executor.submit(() -> handleClient(clientSocket));
                    } catch (IOException e) {
                        if (running) {
                            System.err.println("Error accepting client: " + e.getMessage());
                        }
                    }
                }
            });
        } catch (IOException e) {
            System.err.println("Failed to start gateway: " + e.getMessage());
        }
    }

    private void handleClient(Socket clientSocket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received from device: " + message);
                
                // Simulate processing
                String response = processMessage(message);
                out.println(response);
            }
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing client socket: " + e.getMessage());
            }
        }
    }

    private String processMessage(String message) {
        // Simple message processing simulation
        if (message.startsWith("STATUS:")) {
            return "ACK:STATUS_RECEIVED";
        } else if (message.startsWith("DATA:")) {
            return "ACK:DATA_RECEIVED";
        } else {
            return "ACK:MESSAGE_RECEIVED";
        }
    }

    public void simulateDeviceMessage(String host, int port, String message) {
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println(message);
            String response = in.readLine();
            System.out.println("Gateway response: " + response);

        } catch (IOException e) {
            System.err.println("Failed to send message to gateway: " + e.getMessage());
        }
    }

    public void stop() {
        running = false;
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
            executor.shutdown();
        } catch (IOException e) {
            System.err.println("Error stopping gateway: " + e.getMessage());
        }
    }
}