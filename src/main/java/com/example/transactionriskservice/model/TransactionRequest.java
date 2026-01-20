package com.example.transactionriskservice.model;

public class TransactionRequest {

    private String transactionId;
    private double amount;
    private String country;
    private int accountAgeDays;
    private int transactionsLast24h;

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public int getAccountAgeDays() { return accountAgeDays; }
    public void setAccountAgeDays(int accountAgeDays) { this.accountAgeDays = accountAgeDays; }

    public int getTransactionsLast24h() { return transactionsLast24h; }
    public void setTransactionsLast24h(int transactionsLast24h) { this.transactionsLast24h = transactionsLast24h; }
}
