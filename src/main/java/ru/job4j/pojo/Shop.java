package ru.job4j.pojo;

public class Shop {
    public static int indexOfNull(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            Product p = products[i];
            if (p == null) {
                return i;
            }
        }
        return -1;
    }
}
