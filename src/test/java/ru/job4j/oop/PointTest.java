package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void distance() {
        Point a = new Point(0, 0);
        Point b = new Point(5, 6);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(7.81, 0.01));
    }

    @Test
    public void distance3d() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(5, 6, 12);
        double rsl = a.distance3d(b);
        assertThat(rsl, closeTo(14.318, 0.01));
    }
}