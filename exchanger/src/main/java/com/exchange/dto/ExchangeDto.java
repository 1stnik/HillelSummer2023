package com.exchange.dto;


import com.exchange.model.CurrencyEnum;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ExchangeDto {
    private String phoneNumber;
    private CurrencyEnum currencyFrom; // UAH
    private CurrencyEnum currencyTo;   // USD
    private BigDecimal ammount;

}
