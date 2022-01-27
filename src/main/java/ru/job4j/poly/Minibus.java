package ru.job4j.poly;

public class Minibus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Our bus is about to leave.");
    }

    @Override
    public void arrive() {
        System.out.println("Our bus has just arrived.");
    }
}
