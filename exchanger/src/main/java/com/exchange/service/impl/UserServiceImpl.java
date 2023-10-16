package com.exchange.service.impl;

import com.exchange.dto.UserDto;
import com.exchange.dto.UserRecord;
import com.exchange.dto.UserShortDto;
import com.exchange.dto.UserView;
import com.exchange.exceptions.ActivationUserException;
import com.exchange.exceptions.NotUniqueDataException;
import com.exchange.exceptions.UserNotFoundException;
import com.exchange.mapper.UserMapper;
import com.exchange.model.CurrencyEnum;
import com.exchange.model.Notification;
import com.exchange.model.NotificationTypeEnum;
import com.exchange.model.User;
import com.exchange.model.Wallet;
import com.exchange.repository.NotificationRepository;
import com.exchange.repository.UserRepository;
import com.exchange.repository.WalletRepository;
import com.exchange.service.UserService;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;
    private final NotificationRepository notificationRepository;
    private final UserMapper mapper;

    @Override
    public Long createUser(UserRecord user) {
        int count = userRepository.findAllByPhoneNumberOrEmail(user.phone(), user.email()).size();

        if (count > 0) {
            throw new NotUniqueDataException();
        }

        User userModel = userRepository.save(new User()
                .setFirstName(user.first_name())
                .setLastName(user.last_name())
                .setEmail(user.email())
                .setPhoneNumber(user.phone())
                .setStatus(false));

        Wallet uah = new Wallet()
                .setUser(userModel)
                .setCurrency(CurrencyEnum.UAH)
                .setAmmount(BigDecimal.ZERO)
                .setLastUpdate(new Timestamp(System.currentTimeMillis()));

        Wallet usd = new Wallet()
                .setUser(userModel)
                .setCurrency(CurrencyEnum.USD)
                .setAmmount(BigDecimal.ZERO)
                .setLastUpdate(new Timestamp(System.currentTimeMillis()));

        walletRepository.save(uah);
        walletRepository.save(usd);

        notificationRepository.save(new Notification()
                .setType(NotificationTypeEnum.REGISTRATION)
                .setUser(userModel)
                .setContent(String.format("create user: %s and create 2 wallet: UAH, USD ",
                        userModel.getId())));

        return userModel.getId();
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserDto::fromEntity).toList();
    }

    @Override
    public Page<User> getUsers(Pageable page) {
        return userRepository.findAll(page);
    }

    @Override
    public Page<UserDto> getActiveUsers(Pageable page) {
        return userRepository.findAllByStatus(true, page).map(UserDto::fromEntity);
    }

    @Override
    public UserDto getUserById(Long id) {
        return mapper.toDto(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public User getUserByPhone(String phone) {
        return userRepository.findByPhoneNumber(phone);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<UserView> getUserWalletByPhone(String phone) {
        return userRepository.getUserWalletByPhone(phone);
    }

    @Override
    public boolean activateUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        if (Objects.isNull(user.getDateOfBirth())) {
            throw new ActivationUserException();
        }
        user.setStatus(true);
        userRepository.save(user);
        return true;
    }
}
