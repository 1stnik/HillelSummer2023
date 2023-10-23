package com.exchange.dto;

import com.exchange.model.CurrencyEnum;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TransferDto {
    private String phoneNumber;
    private String distPhoneNumber;
    private CurrencyEnum currency;
    private BigDecimal ammount;

}
