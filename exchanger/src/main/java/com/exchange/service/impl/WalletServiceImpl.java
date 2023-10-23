package com.exchange.service.impl;

import com.exchange.dto.ExchangeDto;
import com.exchange.dto.TransferDto;
import com.exchange.dto.UserWalletsDto;
import com.exchange.dto.VerificationDto;
import com.exchange.dto.WalletRequest;
import com.exchange.exceptions.NotEnoughtMoneyException;
import com.exchange.exceptions.UserNotFoundException;
import com.exchange.exceptions.WalletNotFoundException;
import com.exchange.model.CurrencyEnum;
import com.exchange.model.Notification;
import com.exchange.model.NotificationTypeEnum;
import com.exchange.model.Rate;
import com.exchange.model.Transaction;
import com.exchange.model.TransactionStatusEnum;
import com.exchange.model.TransactionTypeEnum;
import com.exchange.model.User;
import com.exchange.model.Wallet;
import com.exchange.repository.NotificationRepository;
import com.exchange.repository.RateRepository;
import com.exchange.repository.TransactionRepository;
import com.exchange.repository.UserRepository;
import com.exchange.repository.WalletRepository;
import com.exchange.service.WalletService;
import com.exchange.telegram.TelegramBot;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    @Value("${transaction.fee:2}")
    public BigDecimal fee;

    @Value("${transaction.min-fee:5}")
    public BigDecimal minFee;

    private final UserRepository userRepository;
    private final TelegramBot telegramBot;
    private final TransactionRepository transactionRepository;
    private final NotificationRepository notificationRepository;
    private final WalletRepository walletRepository;
    private final RateRepository rateRepository;

    @Override
    public List<Wallet> findAllByUser(User user) {
        return null;
    }

    @Override
    public Wallet findByUserAndCurrency(User user, CurrencyEnum currency) {
        return null;
    }

    @Override
    public UserWalletsDto getUserWallets(String phone) {
        return null;
    }

    @Override
    public UserWalletsDto createWallet(WalletRequest walletRequest) {
        return null;
    }

    @Override
    public Long putMoney(TransferDto transferDto) {
        User user = userRepository.findByPhoneNumber(transferDto.getPhoneNumber());

        String verificationCode = RandomStringUtils.randomAlphabetic(6);
        Transaction transaction = new Transaction()
                .setReceiver(transferDto.getPhoneNumber())
                .setAmount(transferDto.getAmmount())
                .setType(TransactionTypeEnum.PUT)
                .setUpdateAt(LocalDate.now())
                .setCurrency(transferDto.getCurrency())
                .setCode(verificationCode)
                .setStatus(TransactionStatusEnum.PENDING);

        telegramBot.sendMessage(user.getTelegramChatId(), verificationCode);

        transactionRepository.save(transaction);

        notificationRepository.save(new Notification()
                .setType(NotificationTypeEnum.PUT)
                .setUser(user)
                .setContent(String.format("User try put %s %s to wallet. Status pending",
                        transferDto.getAmmount(),
                        transferDto.getCurrency())));

        return transaction.getId();
    }

    @Override
    public Long putMoneyVerification(VerificationDto verificationDto) {
        // from table user - get user by phone number
        User user = userRepository.findByPhoneNumber(verificationDto.phoneNumber());

        // from table trunsaction
        Transaction transaction = transactionRepository.findById(verificationDto.transactionId())
                .orElseThrow(NullPointerException::new);

        // TODO: check balance before execute transaction
        if (transaction.getCode().equals(verificationDto.code())) {
            // from table wallet
            Wallet wallet = walletRepository.findByUserAndCurrency(user, transaction.getCurrency());
            BigDecimal feeTotal = transaction.getAmount()
                    .multiply(fee)
                    .divide(BigDecimal.valueOf(100));

            if (feeTotal.compareTo(minFee) == -1) {
                feeTotal = minFee;
            }

            BigDecimal amount = transaction.getAmount();

            wallet.setAmmount(wallet.getAmmount().add(transaction.getAmount().subtract(feeTotal)));
            walletRepository.save(wallet);

            feeTransaction(feeTotal);
            transaction.setCode(null);
            transaction.setStatus(TransactionStatusEnum.EXECUTED);
            transactionRepository.save(transaction);

            // mongo db - notification
            notificationRepository.save(new Notification()
                    .setType(NotificationTypeEnum.PUT)
                    .setUser(user)
                    .setContent(String.format("User put %s %s to wallet. Status execute",
                            transaction.getAmount(),
                            transaction.getCurrency())));
        }
        return transaction.getId();
    }

    @Override
    public Long getMoney(TransferDto transferDto) {
        User user = userRepository.findByPhoneNumber(transferDto.getPhoneNumber());
        Wallet wallet = walletRepository.findByUserAndCurrency(user, transferDto.getCurrency());
        if (wallet.getAmmount().compareTo(transferDto.getAmmount()) == -1) {
            notificationRepository.save(new Notification()
                    .setType(NotificationTypeEnum.ERROR)
                    .setUser(user)
                    .setContent(String.format(
                            "User %s try get %s %s from wallet. Status error. Not enought money.",
                            transferDto.getPhoneNumber(),
                            transferDto.getAmmount(),
                            transferDto.getCurrency())));

            throw new NotEnoughtMoneyException();
        }

        String verificationCode = RandomStringUtils.randomAlphabetic(6);
        Transaction transaction = new Transaction()
                .setReceiver(transferDto.getPhoneNumber())
                .setAmount(transferDto.getAmmount())
                .setType(TransactionTypeEnum.GET)
                .setUpdateAt(LocalDate.now())
                .setCurrency(transferDto.getCurrency())
                .setCode(verificationCode)
                .setStatus(TransactionStatusEnum.PENDING);

        telegramBot.sendMessage(user.getTelegramChatId(), verificationCode);

        transactionRepository.save(transaction);

        notificationRepository.save(new Notification()
                .setType(NotificationTypeEnum.GET)
                .setUser(user)
                .setContent(String.format("User try get %s %s from wallet. Status pending",
                        transferDto.getAmmount(),
                        transferDto.getCurrency())));

        return transaction.getId();
    }

    @Override
    public Long getMoneyVerification(VerificationDto verificationDto) {
        User user = userRepository.findByPhoneNumber(verificationDto.phoneNumber());

        Transaction transaction = transactionRepository.findById(verificationDto.transactionId())
                .orElseThrow(NullPointerException::new);

        // TODO: check balance before execute transaction
        if (transaction.getCode().equals(verificationDto.code())) {
            Wallet wallet = walletRepository.findByUserAndCurrency(user, transaction.getCurrency());
            wallet.setAmmount(wallet.getAmmount().subtract(transaction.getAmount()));
            walletRepository.save(wallet);
            transaction.setCode(null);
            transaction.setStatus(TransactionStatusEnum.EXECUTED);
            transactionRepository.save(transaction);

            notificationRepository.save(new Notification()
                    .setType(NotificationTypeEnum.PUT)
                    .setUser(user)
                    .setContent(String.format("User get %s %s from wallet. Status execute",
                            transaction.getAmount(),
                            transaction.getCurrency())));
        }
        return transaction.getId();
    }

    @Override
    public Long exchangeMoney(ExchangeDto exchangeDto) {
        User user = userRepository.findByPhoneNumber(exchangeDto.getPhoneNumber());

        List<Wallet> wallets = walletRepository.findAllByUser(user);

        Rate rate = rateRepository.findFirstByCurrencyOrderByReceiveDesc(
                exchangeDto.getCurrencyTo().equals(CurrencyEnum.UAH) ? exchangeDto.getCurrencyFrom()
                        : exchangeDto.getCurrencyTo());

        BigDecimal summ = exchangeDto.getCurrencyTo().equals(CurrencyEnum.UAH) ?
                exchangeDto.getAmmount()
                        .divide(BigDecimal.valueOf(Double.parseDouble(rate.getBuy())), 2,
                                RoundingMode.HALF_UP)
                :
                        exchangeDto.getAmmount()
                                .multiply(BigDecimal.valueOf(Double.parseDouble(rate.getSale())));

        Wallet wFrom = wallets.stream()
                .filter(w -> w.getCurrency().equals(exchangeDto.getCurrencyFrom()))
                .findFirst().orElseThrow(UserNotFoundException::new);

        if (wFrom.getAmmount().compareTo(summ) == -1) {
            throw new NotEnoughtMoneyException();
        }

        String verificationCode = RandomStringUtils.randomAlphabetic(6);

        Transaction transaction = new Transaction()
                .setReceiver(exchangeDto.getPhoneNumber())
                .setAmount(summ)
                .setCurrency(exchangeDto.getCurrencyFrom())
                .setAmountTo(exchangeDto.getAmmount())
                .setCurrencyTo(exchangeDto.getCurrencyTo())
                .setType(TransactionTypeEnum.EXCH)
                .setUpdateAt(LocalDate.now())
                .setCode(verificationCode)
                .setStatus(TransactionStatusEnum.PENDING)
                .setComment("From -> to : " + exchangeDto.getCurrencyFrom() + " -> "
                        + exchangeDto.getCurrencyTo());

        telegramBot.sendMessage(user.getTelegramChatId(), verificationCode);
        transactionRepository.save(transaction);

        notificationRepository.save(new Notification()
                .setType(NotificationTypeEnum.EXCHANGE)
                .setUser(user)
                .setContent("From -> to : " + exchangeDto.getCurrencyFrom() + " -> "
                        + exchangeDto.getCurrencyTo() + "  with status" + transaction.getStatus()));
        return transaction.getId();
    }

    @Override
    public Long exchangeMoneyVerification(VerificationDto verificationDto) {
        User user = userRepository.findByPhoneNumber(verificationDto.phoneNumber());

        Transaction transaction = transactionRepository.findById(verificationDto.transactionId())
                .orElseThrow(NullPointerException::new);

        if (transaction.getCode().equals(verificationDto.code())) {
            Wallet walletFrom = walletRepository.findByUserAndCurrency(user,
                    transaction.getCurrency());
            Wallet walletTo = walletRepository.findByUserAndCurrency(user,
                    transaction.getCurrencyTo());

            // TODO: Check balance before execute transaction
            walletFrom.setAmmount(walletFrom.getAmmount().subtract(transaction.getAmount()));
            walletTo.setAmmount(walletTo.getAmmount().add(transaction.getAmountTo()));

            walletRepository.save(walletFrom);
            walletRepository.save(walletTo);
            transaction.setCode(null);
            transaction.setStatus(TransactionStatusEnum.EXECUTED);
            transactionRepository.save(transaction);

            notificationRepository.save(new Notification()
                    .setType(NotificationTypeEnum.EXCHANGE)
                    .setUser(user)
                    .setContent(String.format("User exchange %s to %s. Status execute",
                            transaction.getCurrency(),
                            transaction.getCurrencyTo())));
        }
        return transaction.getId();
    }

    private void feeTransaction(BigDecimal amount) {
        Wallet wallet = walletRepository.findById(9L).orElseThrow(WalletNotFoundException::new);

        wallet.setAmmount(wallet.getAmmount().add(amount));

        walletRepository.save(wallet);
    }
}
