package com.hillel.lesson_32.ex;

import lombok.SneakyThrows;

public class Ex1 implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
//        Thread.sleep(10000);
        System.out.println(3);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Ex1());
        thread.start();
        System.out.println(1);
        thread.join();
        System.out.println(2);
    }
}
