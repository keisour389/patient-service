package com.smart_physio_therapy.patient_service.controller;

import com.smart_physio_therapy.patient_service.client.DeviceClient;
import com.smart_physio_therapy.patient_service.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/devices")
public class MedicalRecordController {
    private final MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getDeviceById(@PathVariable String id) {
        String test = medicalRecordService.callDevice(id);
        return ResponseEntity.ok(test);
    }
}
