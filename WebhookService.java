package com.example.webhooksolver.service;

import com.example.webhooksolver.dto.GenerateWebhookRequest;
import com.example.webhooksolver.dto.GenerateWebhookResponse;
import com.example.webhooksolver.dto.SolutionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebhookService {

    private final RestTemplate restTemplate;
    private final SqlProblemSolver sqlProblemSolver;

    @Value("${generate.webhook.url}")
    private String generateWebhookUrl;

    public WebhookService(RestTemplate restTemplate, SqlProblemSolver sqlProblemSolver) {
        this.restTemplate = restTemplate;
        this.sqlProblemSolver = sqlProblemSolver;
    }

    public void executeWebhookFlow() {
        try {
            System.out.println("🚀 Starting webhook flow...");

            // Step 1: Generate webhook
            System.out.println("📝 Step 1: Generating webhook...");
            GenerateWebhookResponse webhookResponse = generateWebhook();

            if (webhookResponse != null && webhookResponse.getWebhook() != null) {
                System.out.println("✅ Webhook generated successfully!");
                System.out.println("🌐 Webhook URL: " + webhookResponse.getWebhook());

                // Step 2: Solve SQL problem
                System.out.println("🧠 Step 2: Solving SQL problem...");
                String finalQuery = sqlProblemSolver.solveSqlProblem("22bsa10229");
                System.out.println("📊 SQL Query ready!");

                // Step 3: Submit solution
                System.out.println("📤 Step 3: Submitting solution...");
                submitSolution(webhookResponse.getWebhook(), webhookResponse.getAccessToken(), finalQuery);
            }
        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private GenerateWebhookResponse generateWebhook() {

        GenerateWebhookRequest request = new GenerateWebhookRequest(
                "Ansu M George",
                "22BSA10229",
                "ansumgeorge092004@gmail.com"
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<GenerateWebhookRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<GenerateWebhookResponse> response = restTemplate.exchange(
                generateWebhookUrl,
                HttpMethod.POST,
                entity,
                GenerateWebhookResponse.class
        );

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to generate webhook: " + response.getStatusCode());
        }
    }

    private void submitSolution(String webhookUrl, String accessToken, String finalQuery) {
        SolutionResponse solution = new SolutionResponse(finalQuery);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<SolutionResponse> entity = new HttpEntity<>(solution, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                webhookUrl,
                HttpMethod.POST,
                entity,
                String.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("🎉 Solution submitted successfully!");
            System.out.println("📨 Response: " + response.getBody());
        } else {
            throw new RuntimeException("Failed to submit solution: " + response.getStatusCode());
        }
    }
}