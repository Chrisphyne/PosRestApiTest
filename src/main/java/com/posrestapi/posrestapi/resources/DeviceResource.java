package com.posrestapi.posrestapi.resources;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/devices")
public class DeviceResource {
    @PostMapping("/register")
    public String registerDevice(@RequestBody Map<String, Object> deviceMap) {
        String name = (String) deviceMap.get("name");
        String model = (String) deviceMap.get("model");
        String serialNumber = (String) deviceMap.get("serialNumber");
        return name + ", " + model + ", " + serialNumber ;
    }
}
