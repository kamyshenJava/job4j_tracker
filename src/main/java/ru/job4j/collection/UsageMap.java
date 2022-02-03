package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("aaa@ya.ru", "Ivanov Ivan Ivanovich");
        for (String entry : map.keySet()) {
            System.out.println(entry + " = " + map.get(entry));
        }
    }
}
