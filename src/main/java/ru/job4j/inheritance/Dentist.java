package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private boolean canDoCrowns;

    Dentist() {
    }

    Dentist(String name, String surname, String education, String birthday, boolean workInHospital,
            boolean canDoCrowns) {
        super(name, surname, education, birthday, workInHospital);
        this.canDoCrowns = canDoCrowns;
    }

    public void extract() {
        System.out.println("Okay, sit still. Just a minute.");
    }
}
