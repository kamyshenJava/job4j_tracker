package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book bookOnJava = new Book("Учебник по Java", 350);
        Book loveStory = new Book("Любовь на Марсе", 112);
        Book detective = new Book("Убийство в тумане", 230);
        Book cleanCode = new Book("Clean code", 1);

        Book[] books = new Book[4];
        books[0] = bookOnJava;
        books[1] = loveStory;
        books[2] = detective;
        books[3] = cleanCode;

        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            System.out.println(b.getTitle() + " — " + b.getPages());
        }
        System.out.println("Меняю местами 1 и 4 книги.");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("Книги после перестановки:");
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            System.out.println(b.getTitle() + " — " + b.getPages());
        }
        System.out.println("Книги с названием: \"Clean code\"");
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            if ("Clean code".equals(b.getTitle())) {
                System.out.println(b.getTitle() + " — " + b.getPages());
            }
        }
    }
}
