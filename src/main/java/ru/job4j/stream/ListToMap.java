package ru.job4j.stream;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {

    public static Map<String, Student> convert(List<Student> list) {
        Map<String, Student> temp = list.stream()
                .collect(Collectors.toMap(
                        e -> e.getSurname(),
                        e -> e,
                        (existing, replacement) -> existing
                ));
        return new LinkedHashMap<>(temp);
    }
}
