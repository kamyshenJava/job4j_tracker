package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle minibus = new Minibus();
        Vehicle[] vehicles = {plane, train, minibus};
        for (Vehicle v : vehicles) {
            v.move();
            v.arrive();
        }
    }
}
