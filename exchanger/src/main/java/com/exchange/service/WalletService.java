package com.exchange.service;

import com.exchange.dto.ExchangeDto;
import com.exchange.dto.TransferDto;
import com.exchange.dto.UserWalletsDto;
import com.exchange.dto.VerificationDto;
import com.exchange.dto.WalletRequest;
import com.exchange.model.CurrencyEnum;
import com.exchange.model.User;
import com.exchange.model.Wallet;
import java.util.List;

public interface WalletService {
    List<Wallet> findAllByUser(User user);
    Wallet findByUserAndCurrency(User user, CurrencyEnum currency);
    UserWalletsDto getUserWallets(String phone);
    UserWalletsDto createWallet (WalletRequest walletRequest);
    Long putMoney(TransferDto transferDto);
    Long putMoneyVerification(VerificationDto verificationDto);
    Long getMoney(TransferDto transferDto);
    Long getMoneyVerification(VerificationDto verificationDto);
    Long exchangeMoney(ExchangeDto exchangeDto);
    Long exchangeMoneyVerification(VerificationDto verificationDto);

}
