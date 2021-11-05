package com.posrestapi.posrestapi.services;

import com.posrestapi.posrestapi.domain.Device;
import com.posrestapi.posrestapi.exceptions.PosAuthException;
import com.posrestapi.posrestapi.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService{

    @Autowired
    DeviceRepository deviceRepository;

    @Override
    public Device registerDevice(String name, String model, String serialNumber) throws PosAuthException {
        if( name == null || model == null || serialNumber == null)
            throw new PosAuthException("All fields have to be filled");
        Integer count = deviceRepository.getCountByName(name);
        if(count > 0)
            throw  new PosAuthException("Device name already in use");
        Integer deviceId = deviceRepository.create(name, model, serialNumber);
        return deviceRepository.findById(deviceId);
    }
}
