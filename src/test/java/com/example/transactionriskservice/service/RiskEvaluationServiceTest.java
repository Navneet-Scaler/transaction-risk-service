package com.example.transactionriskservice.service;

import com.example.transactionriskservice.model.TransactionRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RiskEvaluationServiceTest {

    @Test
    void highRiskTransaction_shouldReturnHighScore() {
        RiskEvaluationService service = new RiskEvaluationService();

        TransactionRequest request = new TransactionRequest();
        request.setAmount(20000);
        request.setCountry("NG");
        request.setAccountAgeDays(5);
        request.setTransactionsLast24h(20);

        int score = service.calculateRiskScore(request);

        assertTrue(score >= 60);
    }
}
