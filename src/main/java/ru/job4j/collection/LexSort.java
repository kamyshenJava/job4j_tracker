package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        String[] leftNumbers = left.split("\\.");
        String[] rightNumbers = right.split("\\.");
        int len = Math.min(leftNumbers.length, rightNumbers.length);
        for (int i = 0; i < len; i++) {
            rsl = Integer.compare(Integer.parseInt(leftNumbers[i]), Integer.parseInt(rightNumbers[i]));
            if (rsl != 0) {
                return rsl;
            }
        }
        return rsl;
    }
}
