package ru.job4j.oop;

public class Max {
    public double max(double first, double second) {
        return first > second ? first : second;
    }

    public double max(double first, double second, double third) {
        return max(max(first, second), third);
    }

    public double max(double first, double second, double third, double fourth) {
        return max(max(max(first, second), third), fourth);
    }
}
