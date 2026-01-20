package com.example.transactionriskservice.controller;

import com.example.transactionriskservice.model.TransactionRequest;
import com.example.transactionriskservice.model.TransactionResponse;
import com.example.transactionriskservice.service.RiskEvaluationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/risk")
public class RiskController {

    private final RiskEvaluationService service;

    public RiskController(RiskEvaluationService service) {
        this.service = service;
    }

    @PostMapping("/evaluate")
    public TransactionResponse evaluateRisk(@RequestBody TransactionRequest request) {
        int score = service.calculateRiskScore(request);
        String level = service.determineRiskLevel(score);
        String decision = service.decisionForRisk(level);

        return new TransactionResponse(
                request.getTransactionId(),
                score,
                level,
                decision
        );
    }
}
