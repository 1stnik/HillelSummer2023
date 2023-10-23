package com.exchange.repository;

import com.exchange.model.CurrencyEnum;
import com.exchange.model.User;
import com.exchange.model.Wallet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    List<Wallet> findAllByUser(User user);

    Wallet findByUserAndCurrency(User user, CurrencyEnum currency);

}
