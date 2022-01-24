package ru.job4j.oop;

import static java.lang.Math.*;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double semiPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    public boolean exist(double ab, double ac, double bc) {
        boolean abacGreaterBc = ab + ac > bc;
        boolean bcabGreaterAc = bc + ab > ac;
        boolean bcacGreaterAb = bc + ac > ab;
        return abacGreaterBc & bcabGreaterAc & bcacGreaterAb;
    }

    public double area() {
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        if (this.exist(ab, ac, bc)) {
            double p = semiPerimeter(ab, ac, bc);
            return sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return -1;
    }
}
