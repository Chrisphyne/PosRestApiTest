package com.posrestapi.posrestapi.services;

import com.posrestapi.posrestapi.domain.Device;
import com.posrestapi.posrestapi.exceptions.EtAuthException;

public interface DeviceService {
    Device registerDevice(String name, String model, String serialNumber) throws EtAuthException;
}
