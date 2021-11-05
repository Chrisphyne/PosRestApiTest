package com.posrestapi.posrestapi.domain;

public class Device {
    private Integer deviceId;
    private String name;
    private String model;
    private String serialNumber;

    public Device(Integer deviceId, String name, String model, String serialNumber) {
        this.deviceId = deviceId;
        this.name = name;
        this.model = model;
        this.serialNumber = serialNumber;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
