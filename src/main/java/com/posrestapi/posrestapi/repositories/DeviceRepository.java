package com.posrestapi.posrestapi.repositories;

import com.posrestapi.posrestapi.domain.Device;
import com.posrestapi.posrestapi.exceptions.PosAuthException;

public interface DeviceRepository {
    Integer create(String name, String model, String serialNumber) throws PosAuthException;
    Device findByNameAndSerialNumber(String name, String serialNumber) throws PosAuthException;
    Integer getCountByName(String name);
    Device findById(Integer deviceId);
}
