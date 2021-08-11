package ru.geekbrains;

import ru.geekbrains.w4.lists.hidden.DualLinkedList;

public class Main {

    public static void main(String[] args) {
        DualLinkedList<Product> list = new DualLinkedList<>();
        list.insertFirst(new Product("First", 100));
        list.insertFirst(new Product("Second", 120));
        list.insertFirst(new Product("Third", 10.5f));
        list.insertFirst(new Product("Fourth", 1.315f));
        list.display();
        for (Product p: list) {
            System.out.println(p);
        }
    }
}
