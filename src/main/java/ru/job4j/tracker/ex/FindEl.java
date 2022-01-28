package ru.job4j.tracker.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("The element was not found.");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] arr = {"1", "two", "3"};
        try {
            System.out.println(indexOf(arr, "one"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
