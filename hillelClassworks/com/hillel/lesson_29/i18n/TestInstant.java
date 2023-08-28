package com.hillel.lesson_29.i18n;

import java.time.Instant;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TestInstant {

    private static final String PATTERN_FORMAT = "dd.MM.yyyy HH:mm:ss";

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT)
                .withZone(ZoneId.systemDefault());

        Instant instant = Instant.now();
        String formattedInstant = formatter.format(instant);

        System.out.println(formattedInstant);

        Instant plus5day = instant.plus(Period.ofDays(6));

        formattedInstant = formatter.format(plus5day);

        System.out.println(formattedInstant);

        Instant firstDayOfMonth = Instant.now().plus(Period.ofDays(6)).truncatedTo(ChronoUnit.DAYS).atZone(ZoneOffset.UTC).
                with(TemporalAdjusters.firstDayOfMonth()).toInstant();

        formattedInstant = formatter.format(firstDayOfMonth);

        System.out.println(formattedInstant);

    }

}
