package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] first = o1.split("/", 2);
        String[] second = o2.split("/", 2);
        if (!first[0].equals(second[0])) {
            return second[0].compareTo(first[0]);
        }
        if (first.length != second.length || first.length == 1) {
            return first.length - second.length;
        }
        return first[1].compareTo(second[1]);
    }
}