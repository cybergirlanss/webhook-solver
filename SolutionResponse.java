package com.example.webhooksolver.dto;

public class SolutionResponse {
    private String finalQuery;

    public SolutionResponse() {}

    public SolutionResponse(String finalQuery) {
        this.finalQuery = finalQuery;
    }

    public String getFinalQuery() { return finalQuery; }
    public void setFinalQuery(String finalQuery) { this.finalQuery = finalQuery; }
}