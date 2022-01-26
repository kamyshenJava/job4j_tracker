package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Let's go!");
    }

    @Override
    public void passengers(int number) {
        System.out.println("I've got " + number + " passengers with me.");
    }

    @Override
    public double getFuel(double fuel) {
        return 5000 / fuel;
    }
}
