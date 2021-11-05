package com.posrestapi.posrestapi.repositories;

import com.posrestapi.posrestapi.domain.Device;
import com.posrestapi.posrestapi.exceptions.EtAuthException;

public interface DeviceRepository {
    Integer create(String name, String model, String serialNumber) throws EtAuthException;
    Device findByNameAndSerialNumber(String name, String serialNumber) throws  EtAuthException;
    Integer getCountByName(String name);
    Device findById(Integer deviceId);
}
