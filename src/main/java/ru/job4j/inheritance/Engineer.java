package ru.job4j.inheritance;

public class Engineer extends Profession {

    private boolean workFromHome;

    public Engineer(String name, String surname, String education, String birthday, boolean workFromHome) {
        super(name, surname, education, birthday);
        this.workFromHome = workFromHome;
    }

    public void findJob() {
        System.out.println("I'd like to find a job.");
    }
}
