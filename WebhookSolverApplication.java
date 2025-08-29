package com.example.webhooksolver;

import com.example.webhooksolver.service.WebhookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebhookSolverApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebhookSolverApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(WebhookService webhookService) {
        return args -> {
            webhookService.executeWebhookFlow();
        };
    }
}