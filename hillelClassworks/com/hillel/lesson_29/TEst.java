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

        System.out.println("--------");
        var values = new ArrayList<Integer>();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);

        for (Integer val : values) {
            values.remove(val);
        }
        System.out.println(values);

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
