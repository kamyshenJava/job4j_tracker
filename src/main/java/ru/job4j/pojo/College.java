package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student john = new Student();
        john.setName("John Doe");
        john.setGroup(7);
        john.setDateEnroll(new Date());
        System.out.println(john.getName() + " has enrolled in group " + john.getGroup() + " on " + john.getDateEnroll());
    }
}
