package com.exchange.dto;

public record VerificationDto(String phoneNumber, String code, Long transactionId) {
}
