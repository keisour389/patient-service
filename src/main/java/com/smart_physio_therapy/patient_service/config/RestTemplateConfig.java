package com.smart_physio_therapy.patient_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.*;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestClient restClient() {
        return RestClient.builder().build();
    }
}
