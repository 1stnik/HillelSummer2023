package com.hillel.lesson_29;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TEst {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        shouldGetValueOnReadiness();

        List.of(1, 2, -99, 7, 100, -127, 0, Integer.MIN_VALUE)
                .stream()
                .sorted((o1, o2) -> o2 - o1)
                .forEach(System.out::println);

    }

    static void shouldGetValueOnReadiness() throws ExecutionException, InterruptedException {
        var executorService = Executors.newSingleThreadExecutor();
        var futureValue = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(10);
            return "Hello, world!";
        });
        System.out.println(futureValue.get());
    }
}
