package ru.geekbrains.w4.lists;

public class Deque<E> extends Queue<E>{

    public void addLast(E value) {
        list().insertLast(value);
    }

    public E getFirst() {
        return list().deleteFirst();
    }
}
