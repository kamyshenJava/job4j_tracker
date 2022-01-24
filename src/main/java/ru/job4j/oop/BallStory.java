package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball kolobok = new Ball();
        Hare zayac = new Hare();
        Wolf volk = new Wolf();
        Fox lisa = new Fox();
        zayac.tryEat(kolobok);
        volk.tryEat(kolobok);
        lisa.tryEat(kolobok);
    }
}
