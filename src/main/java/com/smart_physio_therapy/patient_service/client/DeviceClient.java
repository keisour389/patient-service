package com.smart_physio_therapy.patient_service.client;

import com.smart_physio_therapy.patient_service.client.fallback.DeviceClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "DEVICE-SERVICE",
        fallback = DeviceClientFallback.class
)
public interface DeviceClient {
    @GetMapping("/api/devices/{deviceId}")
    String getDeviceById(@PathVariable String deviceId);
}
