package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private double experience;

    Programmer() {
    }

    Programmer(String name, String surname, String education, String birthday, boolean workFromHome,
               double experience) {
        super(name, surname, education, birthday, workFromHome);
        this.experience = experience;
    }

    public void quitJob() {
        System.out.println("I'm quitting.");
    }
}
