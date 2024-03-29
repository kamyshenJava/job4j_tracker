package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"10"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(10));
    }

    @Test
    public void whenValidInputFewTimes() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "2", "3"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int[] rsl = new int[3];
        rsl[0] = input.askInt("Enter menu:");
        rsl[1] = input.askInt("Enter menu:");
        rsl[2] = input.askInt("Enter menu:");
        int[] expected = {1, 2, 3};
        assertArrayEquals(rsl, expected);
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-1));
    }
}