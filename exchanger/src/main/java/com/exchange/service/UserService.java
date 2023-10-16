package com.exchange.service;

import com.exchange.dto.UserDto;
import com.exchange.dto.UserRecord;
import com.exchange.dto.UserView;
import com.exchange.model.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Long createUser(UserRecord user);

    List<UserDto> getAllUsers();

    Page<User> getUsers(Pageable page);

    Page<UserDto>getActiveUsers(Pageable page);

    UserDto getUserById(Long id);

    User getUserByPhone(String phone);

    void saveUser(User user);

    List<UserView> getUserWalletByPhone(String phone);

    boolean activateUser(Long userId);

}
