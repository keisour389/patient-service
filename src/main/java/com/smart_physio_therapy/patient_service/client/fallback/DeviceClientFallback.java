package com.smart_physio_therapy.patient_service.client.fallback;

import com.smart_physio_therapy.patient_service.client.DeviceClient;
import org.springframework.stereotype.Component;

@Component
public class DeviceClientFallback implements DeviceClient {
    @Override
    public String getDeviceById(String deviceId) {
        System.err.println("Device Service is unavailable. Using fallback.");
        return "Unknown N/A device";
    }
}
