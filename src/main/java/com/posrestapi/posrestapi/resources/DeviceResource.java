package com.posrestapi.posrestapi.resources;

import com.posrestapi.posrestapi.domain.Device;
import com.posrestapi.posrestapi.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/devices")
public class DeviceResource {

    @Autowired
    DeviceService deviceService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerDevice(@RequestBody Map<String, Object> deviceMap) {
        String name = (String) deviceMap.get("name");
        String model = (String) deviceMap.get("model");
        String serialNumber = (String) deviceMap.get("serialNumber");
        Device device = deviceService.registerDevice(name, model, serialNumber);
        Map<String, String> map = new HashMap<>();
        map.put("message", "Successfully Registered");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
