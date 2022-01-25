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

        allBooks(books);
        System.out.println("Меняю местами 1 и 4 книги.");
        changeOrder(books, 0, 3);
        System.out.println("Книги после перестановки:");
        allBooks(books);
        System.out.println("Книги с названием: \"Clean code\"");
        pickBook(books, "Clean code");
    }

    private static void allBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            System.out.println(b.getTitle() + " — " + b.getPages());
        }
    }

    private static void pickBook(Book[] books, String title) {
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            if (b.getTitle().equals(title)) {
                System.out.println(b.getTitle() + " — " + b.getPages());
            }
        }
    }

    private static void changeOrder(Book[] books, int first, int second) {
        Book temp = books[first];
        books[first] = books[second];
        books[second] = temp;
    }
}
