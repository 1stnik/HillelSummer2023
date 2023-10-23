package com.exchange.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TransactionStatusEnum status;

    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency_to")
    private CurrencyEnum currencyTo;

    @Column(name = "amount_to")
    private BigDecimal amountTo;

    @Enumerated(EnumType.STRING)
    private TransactionTypeEnum type;

    private String sender;

    private String receiver;

    @Column(name = "update_at")
    private LocalDate updateAt;

    private String comment;

    private String code;
}
