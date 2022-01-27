package ru.job4j.poly;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Get ready for takeoff!");
    }

    @Override
    public void arrive() {
        System.out.println("Our plane has just landed.");
    }
}
