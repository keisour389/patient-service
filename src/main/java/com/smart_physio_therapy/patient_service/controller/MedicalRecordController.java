package com.smart_physio_therapy.patient_service.controller;

import com.smart_physio_therapy.patient_service.service.MedicalRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalRecordController {
    private final MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @GetMapping("/test-device/{id}")
    public ResponseEntity<String> getDeviceById(@PathVariable String id) {
        String response;
        response = medicalRecordService.getDeviceById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/test-in-count-time")
    public String testBreaker(@RequestParam(defaultValue = "1") int count) {
        for (int i = 0; i < count; i++) {
            try {
                String result = medicalRecordService.getDeviceById("abc");
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Exception caught: " + e.getMessage());
            }
        }
        return "Done " + count + " calls";
    }
}
