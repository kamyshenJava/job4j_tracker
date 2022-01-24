package ru.job4j.oop;

import java.util.concurrent.Callable;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int num) {
        return num - x;
    }

    public int divide(int num) {
        return num / x;
    }

    public int sumAllOperation(int num) {
        return sum(num) + multiply(num) + minus(num) + divide(num);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(sum(7));
        System.out.println(minus(7));
        System.out.println(calculator.multiply(7));
        System.out.println(calculator.divide(7));
        System.out.println(calculator.sumAllOperation(7));
    }
}
