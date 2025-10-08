package com.iot.dashboard.database;

import com.iot.dashboard.model.Device;
import com.iot.dashboard.model.SensorData;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.net.URI;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DynamoDBService {
    private final DynamoDbClient dynamoDb;
    private static final String DEVICES_TABLE = "IoTDevices";
    private static final String SENSOR_DATA_TABLE = "SensorData";

    public DynamoDBService() {
        try {
            this.dynamoDb = DynamoDbClient.builder()
                    .endpointOverride(URI.create("http://localhost:8000"))
                    .region(Region.US_EAST_1)
                    .credentialsProvider(StaticCredentialsProvider.create(
                            AwsBasicCredentials.create("dummy", "dummy")))
                    .build();
            initializeTables();
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize DynamoDB: " + e.getMessage(), e);
        }
    }

    private void initializeTables() {
        try {
            createDevicesTable();
            createSensorDataTable();
        } catch (Exception e) {
            System.out.println("Tables may already exist: " + e.getMessage());
        }
    }

    private void createDevicesTable() {
        CreateTableRequest request = CreateTableRequest.builder()
                .tableName(DEVICES_TABLE)
                .keySchema(KeySchemaElement.builder()
                        .attributeName("deviceId")
                        .keyType(KeyType.HASH)
                        .build())
                .attributeDefinitions(AttributeDefinition.builder()
                        .attributeName("deviceId")
                        .attributeType(ScalarAttributeType.S)
                        .build())
                .billingMode(BillingMode.PAY_PER_REQUEST)
                .build();

        dynamoDb.createTable(request);
    }

    private void createSensorDataTable() {
        CreateTableRequest request = CreateTableRequest.builder()
                .tableName(SENSOR_DATA_TABLE)
                .keySchema(
                        KeySchemaElement.builder()
                                .attributeName("deviceId")
                                .keyType(KeyType.HASH)
                                .build(),
                        KeySchemaElement.builder()
                                .attributeName("timestamp")
                                .keyType(KeyType.RANGE)
                                .build())
                .attributeDefinitions(
                        AttributeDefinition.builder()
                                .attributeName("deviceId")
                                .attributeType(ScalarAttributeType.S)
                                .build(),
                        AttributeDefinition.builder()
                                .attributeName("timestamp")
                                .attributeType(ScalarAttributeType.S)
                                .build())
                .billingMode(BillingMode.PAY_PER_REQUEST)
                .build();

        dynamoDb.createTable(request);
    }

    public void saveDevice(Device device) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("deviceId", AttributeValue.builder().s(device.getDeviceId()).build());
        item.put("name", AttributeValue.builder().s(device.getName()).build());
        item.put("type", AttributeValue.builder().s(device.getType()).build());
        item.put("status", AttributeValue.builder().s(device.getStatus()).build());
        item.put("location", AttributeValue.builder().s(device.getLocation()).build());
        item.put("lastUpdated", AttributeValue.builder().s(device.getLastUpdated().toString()).build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName(DEVICES_TABLE)
                .item(item)
                .build();

        dynamoDb.putItem(request);
    }

    public Device getDevice(String deviceId) {
        GetItemRequest request = GetItemRequest.builder()
                .tableName(DEVICES_TABLE)
                .key(Map.of("deviceId", AttributeValue.builder().s(deviceId).build()))
                .build();

        GetItemResponse response = dynamoDb.getItem(request);
        if (response.hasItem()) {
            Map<String, AttributeValue> item = response.item();
            Device device = new Device();
            device.setDeviceId(item.get("deviceId").s());
            device.setName(item.get("name").s());
            device.setType(item.get("type").s());
            device.setStatus(item.get("status").s());
            device.setLocation(item.get("location").s());
            return device;
        }
        return null;
    }

    public List<Device> getAllDevices() {
        ScanRequest request = ScanRequest.builder()
                .tableName(DEVICES_TABLE)
                .build();

        ScanResponse response = dynamoDb.scan(request);
        List<Device> devices = new ArrayList<>();

        for (Map<String, AttributeValue> item : response.items()) {
            Device device = new Device();
            device.setDeviceId(item.get("deviceId").s());
            device.setName(item.get("name").s());
            device.setType(item.get("type").s());
            device.setStatus(item.get("status").s());
            device.setLocation(item.get("location").s());
            devices.add(device);
        }
        return devices;
    }

    public void saveSensorData(SensorData sensorData) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("deviceId", AttributeValue.builder().s(sensorData.getDeviceId()).build());
        item.put("timestamp", AttributeValue.builder().s(sensorData.getTimestamp().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)).build());
        item.put("sensorType", AttributeValue.builder().s(sensorData.getSensorType()).build());
        item.put("value", AttributeValue.builder().n(String.valueOf(sensorData.getValue())).build());
        item.put("unit", AttributeValue.builder().s(sensorData.getUnit()).build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName(SENSOR_DATA_TABLE)
                .item(item)
                .build();

        dynamoDb.putItem(request);
    }

    public void close() {
        dynamoDb.close();
    }
}