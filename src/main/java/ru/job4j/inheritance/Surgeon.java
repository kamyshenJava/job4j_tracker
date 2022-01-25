package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private boolean neurosurgeon;

    public Surgeon(String name, String surname, String education, String birthday, boolean workInHospital,
            boolean neurosurgeon) {
        super(name, surname, education, birthday, workInHospital);
        this.neurosurgeon = neurosurgeon;
    }

    public void operate() {
        System.out.println("Where's my scalpel?");
    }
}
