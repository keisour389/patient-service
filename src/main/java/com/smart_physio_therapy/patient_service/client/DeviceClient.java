package com.smart_physio_therapy.patient_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "device-service")
public interface DeviceClient {
    @GetMapping("/api/devices/{deviceId}")
    String getDeviceById(@PathVariable String deviceId);
}
