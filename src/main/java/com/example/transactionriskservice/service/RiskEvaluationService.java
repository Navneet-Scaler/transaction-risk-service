package com.example.transactionriskservice.service;

import com.example.transactionriskservice.model.TransactionRequest;
import org.springframework.stereotype.Service;

@Service
public class RiskEvaluationService {

    public int calculateRiskScore(TransactionRequest request) {
        int score = 0;

        if (request.getAmount() > 10000) score += 40;
        if (!"US".equalsIgnoreCase(request.getCountry())) score += 20;
        if (request.getAccountAgeDays() < 30) score += 15;
        if (request.getTransactionsLast24h() > 10) score += 10;

        return score;
    }

    public String determineRiskLevel(int score) {
        if (score > 60) return "HIGH";
        if (score > 30) return "MEDIUM";
        return "LOW";
    }

    public String decisionForRisk(String level) {
        return switch (level) {
            case "HIGH" -> "REVIEW";
            case "MEDIUM" -> "ALLOW_WITH_MONITORING";
            default -> "ALLOW";
        };
    }
}
