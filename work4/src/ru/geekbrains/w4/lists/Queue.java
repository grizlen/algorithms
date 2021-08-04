package ru.geekbrains.w4.lists;

import ru.geekbrains.w4.lists.hidden.DualLinkedList;

public class Queue<E> {

    private final DualLinkedList<E> list;

    public Queue() {
        list = new DualLinkedList<>();
    }

    public void add(E value) {
        list.insertFirst(value);
    }

    public E get() {
        return list.deleteLast();
    }

    protected DualLinkedList<E> list() {
        return list;
    }
}
