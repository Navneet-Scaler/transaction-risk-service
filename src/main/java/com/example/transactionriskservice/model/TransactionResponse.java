package com.example.transactionriskservice.model;

public class TransactionResponse {

    private String transactionId;
    private int riskScore;
    private String riskLevel;
    private String decision;

    public TransactionResponse(String transactionId, int riskScore, String riskLevel, String decision) {
        this.transactionId = transactionId;
        this.riskScore = riskScore;
        this.riskLevel = riskLevel;
        this.decision = decision;
    }

    public String getTransactionId() { return transactionId; }
    public int getRiskScore() { return riskScore; }
    public String getRiskLevel() { return riskLevel; }
    public String getDecision() { return decision; }
}
