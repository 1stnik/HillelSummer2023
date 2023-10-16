package com.exchange.service;

import com.exchange.model.CurrencyEnum;
import com.exchange.model.User;
import com.exchange.model.Wallet;
import java.util.List;

public interface WalletService {
    List<Wallet> findAllByUser(User user);

    Wallet findByUserAndCurrency(User user, CurrencyEnum currency);

}
