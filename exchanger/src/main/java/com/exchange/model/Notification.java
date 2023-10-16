package com.exchange.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Notification {
    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private NotificationTypeEnum type;

    private String content;

    private User user;

    private LocalDate createAt = LocalDate.now();
}
