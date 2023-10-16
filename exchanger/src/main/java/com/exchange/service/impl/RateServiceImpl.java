package com.exchange.service.impl;

import com.exchange.exceptions.ExternalHttpCallException;
import com.exchange.model.CurrencyEnum;
import com.exchange.model.Notification;
import com.exchange.model.NotificationTypeEnum;
import com.exchange.model.Rate;
import com.exchange.repository.NotificationRepository;
import com.exchange.repository.RateRepository;
import com.exchange.service.RateService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {

    @Value("${bank.rate.url}")
    private String bankRateUrl;
    private final RateRepository rateRepository;
    private final NotificationRepository notificationRepository;

    @Scheduled(cron = "0 * * * * MON-FRI") // means once per minute on weekdays
    /*
    +-------------------- second (0 - 59)
    |  +----------------- minute (0 - 59)
    |  |  +-------------- hour (0 - 23)
    |  |  |  +----------- day of month (1 - 31)
    |  |  |  |  +-------- month (1 - 12)
    |  |  |  |  |  +----- day of week (0 - 6) (Sunday=0 or 7)
    |  |  |  |  |  |  +-- year [optional]
    |  |  |  |  |  |  |
    *  *  *  *  *  *  * command to be executed
     */
    @Override
    public void getRates() throws JsonProcessingException {
        log.info("start cron job: " + Instant.now());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(bankRateUrl, String.class);
        log.error(response.getBody());

        if (response.getStatusCode().isError()){
            throw new ExternalHttpCallException("Could not retrieve rate from bank");
        }

        ObjectMapper om = new ObjectMapper();
        JsonNode jsonNode = om.readTree(response.getBody());

        jsonNode.forEach(c -> {
            if ( c.get("ccy").asText().equals("USD")
                    || c.get("ccy").asText().equals("EUR")) {
                Rate rate = new Rate()
                        .setBuy(c.get("buy").asText())
                        .setSale(c.get("sale").asText())
                        .setReceive(new Timestamp(System.currentTimeMillis()))
                        .setCurrency(CurrencyEnum.valueOf(c.get("ccy").asText()));
                rateRepository.save(rate);
            }
        });


        notificationRepository.save(
                new Notification()
                        .setType(NotificationTypeEnum.RATE)
                        .setContent(String.format(jsonNode.toString())));
        log.info("Finish cron job: " + Instant.now());
    }
}
