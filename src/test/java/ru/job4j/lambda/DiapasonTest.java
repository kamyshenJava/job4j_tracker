package ru.job4j.lambda;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
import static org.hamcrest.Matchers.is;

public class DiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapason dpz = new Diapason();
        List<Double> result = dpz.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSqrFunctionThenSqrResult() {
        Diapason dpz = new Diapason();
        List<Double> result = dpz.diapason(5, 8, x -> x * x + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenAnyPowerFunctionThenAnyPowerResult() {
        Diapason dpz = new Diapason();
        int a = 5;
        List<Double> result = dpz.diapason(5, 8, x -> Math.pow(a, x) + 1);
        List<Double> expected = Arrays.asList(3126D, 15626D, 78126D);
        assertThat(result, is(expected));
    }
}