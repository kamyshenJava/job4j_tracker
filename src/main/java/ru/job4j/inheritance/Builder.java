package ru.job4j.inheritance;

public class Builder extends Engineer {

    private String currentProject;

    Builder() {
    }

    Builder(String name, String surname, String education, String birthday, boolean workFromHome,
               String currentProject) {
        super(name, surname, education, birthday, workFromHome);
        this.currentProject = currentProject;
    }

    public void build() {
        System.out.println("I build something important.");
    }
}
