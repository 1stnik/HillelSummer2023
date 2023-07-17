package com.hillel.lesson_02;

public class CalcDep {
    private static int money = 1000;
    private static int years = 5;
    private static int percent = 10;
    public static void main(String[] args) {
        countingOperation();
    }


    public static void countingOperation() {
        System.out.println("Сумма депозита: " + money + " грн.");
        System.out.println("Процент годовых: " + percent + "%");
        System.out.println("Заданное количество лет: " + years);
        System.out.println("************************************************");

        double sumPercentOneYer = money * percent / 100 * 1;
        System.out.println("Годовой процентный доход составляет " + sumPercentOneYer + "грн.");

        double sumPercent = money * percent / 100 * years;
        System.out.println("Сумма процентного дохода составляет: " + sumPercent + "грн.");

        double result = money + sumPercent;
        System.out.println("Общий баланс составялет: " + result + "грн.");
    }
}
