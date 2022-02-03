package ru.job4j.tracker;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemAscByNameTest {

    @Test
    public void compare() {
        Item milk = new Item("Milk");
        Item bread = new Item("Bread");
        Item butter = new Item("Butter");
        Item anything = new Item("Anything");

        List<Item> items = Arrays.asList(milk, bread, butter, anything);
        Collections.sort(items);
        List<Item> expected = Arrays.asList(anything, bread, butter, milk);
        assertThat(items, is(expected));
    }
}