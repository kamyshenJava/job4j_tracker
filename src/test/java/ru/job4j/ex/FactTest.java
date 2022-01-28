package ru.job4j.ex;

import org.junit.Test;
import ru.job4j.ex.Fact;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenArgBelowZeroThenException() {
        Fact fact = new Fact();
        fact.calc(-1);
    }

}