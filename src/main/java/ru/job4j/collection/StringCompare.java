package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int len = Math.min(left.length(), right.length());
        for (int i = 0; i < len; i++) {
            rsl = Character.compare(left.charAt(i), right.charAt(i));
            if (rsl != 0) {
                return rsl;
            }
        }
        if (left.length() != right.length()) {
            rsl = left.length() < right.length() ? -1 : 1;
        }
        return rsl;
    }
}
