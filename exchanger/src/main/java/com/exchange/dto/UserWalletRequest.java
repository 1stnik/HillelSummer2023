package com.exchange.dto;

import com.exchange.model.CurrencyEnum;

public record UserWalletRequest(String phone, CurrencyEnum currencyIso) {
}
