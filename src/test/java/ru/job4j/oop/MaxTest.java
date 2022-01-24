package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.Matchers.closeTo;

import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void maxTwoNumbers() {
        double first = 1.3;
        double second = 5.2;
        Max max = new Max();
        double rsl = max.max(first, second);
        assertThat(rsl, closeTo(5.2, 0.001));
    }

    @Test
    public void testMaxThreeNumbers() {
        double first = 1.3;
        double second = 5.2;
        double third = 6;
        Max max = new Max();
        double rsl = max.max(first, second, third);
        assertThat(rsl, closeTo(6, 0.001));
    }

    @Test
    public void testMaxFourNumbers() {
        double first = 1.3;
        double second = 4.5;
        double third = 2.5;
        double fourth = 4.5;
        Max max = new Max();
        double rsl = max.max(first, second, third, fourth);
        assertThat(rsl, closeTo(4.5, 0.001));
    }
}