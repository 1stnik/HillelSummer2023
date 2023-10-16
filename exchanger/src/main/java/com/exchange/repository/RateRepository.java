package com.exchange.repository;

import com.exchange.model.CurrencyEnum;
import com.exchange.model.Rate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {

    List<Rate> findByCurrency(CurrencyEnum currencyEnum);

    Rate findFirstByCurrencyOrderByReceiveDesc(CurrencyEnum currencyEnum);
}
