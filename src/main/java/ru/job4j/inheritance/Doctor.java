package ru.job4j.inheritance;

public class Doctor extends Profession {

    private boolean workInHospital;

    Doctor() {
    }

    Doctor(String name, String surname, String education, String birthday, boolean workInHospital) {
        super(name, surname, education, birthday);
        this.workInHospital = workInHospital;
    }

    public void heal() {
        System.out.println("Let's take care of your problem.");
    }
}
