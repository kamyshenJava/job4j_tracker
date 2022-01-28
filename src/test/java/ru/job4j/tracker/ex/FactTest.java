package ru.job4j.tracker.ex;

import org.junit.Test;


public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenArgBelowZeroThenException() {
        Fact fact = new Fact();
        fact.calc(-1);
    }

}