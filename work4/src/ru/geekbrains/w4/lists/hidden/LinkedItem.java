package ru.geekbrains.w4.lists.hidden;

public class LinkedItem<T> {

    private LinkedItem<T> next;
    private T data;

    public LinkedItem(T value, LinkedItem<T> next) {
        data = value;
        this.next = next;
    }

    public void setNext(LinkedItem<T> item) {
        next = item;
    }

    public T getData() {
        return data;
    }

    public LinkedItem<T> getNext() {
        return next;
    }

    public boolean isLast() {
        return next == null;
    }

    public boolean dataEquals(T value) {
        return data.equals(value);
    }

    @Override
    public String toString() {
        return "{" + data + "}";
    }
}
