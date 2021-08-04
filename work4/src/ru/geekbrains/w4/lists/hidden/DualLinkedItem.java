package ru.geekbrains.w4.lists.hidden;

public class DualLinkedItem<T> extends LinkedItem<T>{

    private DualLinkedItem<T> prev;

    public DualLinkedItem(T value, DualLinkedItem<T> next, DualLinkedItem<T> prev) {
        super(value, next);
        this.prev = prev;
    }


    public DualLinkedItem<T> getPrev() {
        return prev;
    }

    public void setPrev(DualLinkedItem<T> item) {
        prev = item;
    }

    public boolean isFirst() {
        return prev == null;
    }
}
