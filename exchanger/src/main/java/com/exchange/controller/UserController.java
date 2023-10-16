package com.exchange.controller;

import com.exchange.dto.UserDto;
import com.exchange.dto.UserRecord;
import com.exchange.dto.UserView;
import com.exchange.dto.UserWalletRequest;
import com.exchange.model.User;
import com.exchange.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping()
    public Long addUser(@RequestBody UserRecord user) {
        return userService.createUser(user);
    }

    @GetMapping()
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/page")
    public Page<User> getAllUsers(@RequestParam int page, @RequestParam int size) {
        return userService.getUsers(PageRequest.of(page, size));

    }

    @GetMapping("/active")
    public Page<UserDto> getActiveUsers(@RequestParam int page, @RequestParam int size) {
        return userService.getActiveUsers(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@RequestParam Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/wallet")
    public List<UserView> getUserById(@RequestBody UserWalletRequest user) {
        return userService.getUserWalletByPhone(user.phone());
    }

    @PutMapping("/{userid}/activate")
    public boolean activateUser(@PathVariable Long userid) {
        return userService.activateUser(userid);
    }

    @PutMapping()
    public void updateUser(@RequestBody User user) {
        userService.saveUser(user);
    }
}
