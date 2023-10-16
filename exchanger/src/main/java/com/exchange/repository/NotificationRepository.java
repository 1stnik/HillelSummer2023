package com.exchange.repository;

import com.exchange.model.Notification;
import com.exchange.model.NotificationTypeEnum;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface NotificationRepository extends MongoRepository<Notification, String> {

    List<Notification> findAllByType(NotificationTypeEnum notificationTypeEnum);
}
