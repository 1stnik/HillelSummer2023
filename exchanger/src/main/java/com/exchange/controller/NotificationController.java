package com.exchange.controller;

import com.exchange.model.Notification;
import com.exchange.model.NotificationTypeEnum;
import com.exchange.repository.NotificationRepository;
import java.util.List;
import liquibase.license.LicenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1/notification")
@RequiredArgsConstructor
@Slf4j
public class NotificationController {

   private final NotificationRepository notificationRepository;

    @GetMapping()
    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    @GetMapping("/{type}")
    public List<Notification> getAllByType(@PathVariable NotificationTypeEnum type) {
        return notificationRepository.findAllByType(type);
    }


}
