package com.exchange.dto;


import com.exchange.model.CurrencyEnum;
import com.exchange.model.Wallet;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Builder
@Accessors(chain = true)
public class WalletDto {
    private CurrencyEnum currency;

    private BigDecimal ammount;

    public static WalletDto fromEntity(Wallet wallet) {
        return WalletDto.builder()
                .ammount(wallet.getAmmount())
                .currency(wallet.getCurrency())
                .build();
    }
}
