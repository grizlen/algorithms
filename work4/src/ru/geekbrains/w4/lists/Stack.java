package ru.geekbrains.w4.lists;

import ru.geekbrains.w4.lists.hidden.LinkedList;

public class Stack<T> {

    private final LinkedList<T> list;

    public Stack() {
        list = new LinkedList<>();
    }

    public void push(T value) {
        list.insertFirst(value);
    }

    public T pop() {
        return list.deleteFirst();
    }
}
