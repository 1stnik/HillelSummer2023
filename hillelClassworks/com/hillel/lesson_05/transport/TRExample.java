package com.hillel.lesson_05.transport;

public class TRExample {
    public static void main(String[] args) {
        Transport tr = new Transport("Mersedes");

        Car car = new Car("Audi");

        car.setTankSize(10);
        System.out.println(car);

        car.setTankSize(20);
        System.out.println(car);

        getFuel(car);
        System.out.println(car);

        getFuel(car);
        System.out.println(car);
    }

    private static void getFuel(Car car){
        car.setTankSize(car.getTankSize() + 20);
    }
}
