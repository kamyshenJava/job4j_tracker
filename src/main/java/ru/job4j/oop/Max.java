package ru.job4j.oop;

public class Max {
    public double max(double first, double second) {
        return first > second ? first : second;
    }

    public double max(double first, double second, double third) {
        double temp = max(first, second);
        return temp > third ? temp : third;
    }

    public double max(double first, double second, double third, double fourth) {
        double temp = max(first, second, third);
        return temp > fourth ? temp : fourth;
    }
}
