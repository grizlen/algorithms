package ru.geekbrains;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Pt2Deque<T> {

    public static void main(String[] args) {
        Pt2Deque<Integer> deq = new Pt2Deque<>(Integer.class);
        deq.putFirst(1);
        deq.print();
        deq.putFirst(2);
        deq.print();
        deq.putLast(3);
        deq.print();
        System.out.println(deq.getFirst());
        System.out.println(deq.getFirst());
        System.out.println(deq.getFirst());
        System.out.println(deq.getFirst());
        deq.print();
        deq.putFirst(1);
        deq.print();
        System.out.println(deq.getLast());
        deq.print();
        System.out.println(deq.getLast());
        deq.print();
    }

    private final Class<T> itemClass;

    private T[] items;

    private int size;

    public Pt2Deque(Class<T> itemClass) {
        this.itemClass = itemClass;
        items = (T[]) Array.newInstance(itemClass, 0);
        size = 0;
    }

    private void print() {
        System.out.println(Arrays.toString(items));
    }

    public void putFirst(T value) {
        T[] tmp = (T[]) Array.newInstance(itemClass, items.length + 1);
        System.arraycopy(items, 0, tmp, 1, items.length);
        tmp[0] = value;
        items = tmp;
    }

    private void putLast(T value) {
        T[] tmp = (T[]) Array.newInstance(itemClass, items.length + 1);
        System.arraycopy(items, 0, tmp, 0, items.length);
        tmp[items.length] = value;
        items = tmp;
    }

    private T getFirst() {
        T result = null;
        if (items.length > 0) {
            result = items[0];
            T[] tmp = (T[]) Array.newInstance(itemClass, items.length - 1);
            if (tmp.length > 0) {
                System.arraycopy(items, 1, tmp, 0, tmp.length);
            }
            items = tmp;
        }
        return result;
    }

    private T getLast() {
        T result = null;
        if (items.length > 0) {
            result = items[items.length - 1];
            T[] tmp = (T[]) Array.newInstance(itemClass, items.length - 1);
            if (tmp.length > 0) {
                System.arraycopy(items, 0, tmp, 0, tmp.length);
            }
            items = tmp;
        }
        return result;
    }
}
