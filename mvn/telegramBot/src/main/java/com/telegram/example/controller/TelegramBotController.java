package com.telegram.example.controller;

import com.telegram.example.dto.BotUsersService;
import com.telegram.example.telegram.TelegramBot;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class TelegramBotController {

    private final BotUsersService botUsersService;
    private final TelegramBot telegramBot;

    private static final String CALL_ENDPOINT = "call endpoint : %s ";

    @GetMapping("/users")
    public Set<Long> getUsers() {
        return botUsersService.getUsers();
    }

    @PostMapping("/user/{userId}")
    public void sendMessage(@PathVariable("userId") Long userId, @RequestParam String message) {
         telegramBot.sendMessage(userId, message);
    }

    @PostMapping("/user")
    public void sendMessage( @RequestParam String message) {
        botUsersService.getUsers().forEach(id -> telegramBot.sendMessage(id, message));
    }
}
