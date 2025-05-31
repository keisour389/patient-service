package com.smart_physio_therapy.patient_service.service;

import com.smart_physio_therapy.patient_service.client.DeviceClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService {


    private final DeviceClient deviceClient;

    public MedicalRecordService(DeviceClient deviceClient) {
        this.deviceClient = deviceClient;
    }

    @CircuitBreaker(name = "deviceService", fallbackMethod = "fallbackGetDevice")
    public String getDeviceById(String deviceId) {
        return deviceClient.getDeviceById(deviceId);
    }

    public String fallbackGetDevice(String deviceId, Throwable t) {
        return "Fallback triggered for device: " + deviceId;
    }
}
