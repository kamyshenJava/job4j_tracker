package ru.job4j.poly;

import ru.job4j.inheritance.Doctor;

public interface Transport {
    void drive();

    void passengers(int number);

    double getFuel(double fuel);
}
