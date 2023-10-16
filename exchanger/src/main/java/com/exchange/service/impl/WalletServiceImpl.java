package com.exchange.service.impl;

import com.exchange.model.CurrencyEnum;
import com.exchange.model.User;
import com.exchange.model.Wallet;
import com.exchange.service.WalletService;
import java.util.List;

public class WalletServiceImpl implements WalletService {

    @Override
    public List<Wallet> findAllByUser(User user) {
        return null;
    }

    @Override
    public Wallet findByUserAndCurrency(User user, CurrencyEnum currency) {
        return null;
    }
}
