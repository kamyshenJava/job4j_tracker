package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Our train is leaving in 5 minutes.");
    }

    @Override
    public void arrive() {
        System.out.println("Our train has just arrived.");
    }
}
