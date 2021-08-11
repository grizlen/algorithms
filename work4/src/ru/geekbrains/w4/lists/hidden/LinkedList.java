package ru.geekbrains.w4.lists.hidden;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E>{

    private LinkedItem<E> first;

    protected LinkedItem<E> getFirst() {
        return first;
    }
    protected void setFirst(LinkedItem<E> item) {
        first = item;
    }

    public void insertFirst(E value) {
        setFirst(new LinkedItem<E>(value, first));
    }

    public E deleteFirst() {
        if (first != null) {
            E result = first.getData();
            first = first.getNext();
            return result;
        }
        return null;
    }

    public E remove(E value) {
        LinkedItem<E> item = first, prev = null;
        while (item != null) {
            if (item.dataEquals(value)) {
                if (item == first) {
                    return deleteFirst();
                } else {
                    E result = item.getData();
                    prev.setNext(item.getNext());
                    return result;
                }
            }
            prev = item;
            item = item.getNext();
        }
        return null;
    }

    public void display() {
        StringBuilder sb = new StringBuilder("[\n");
        LinkedItem<E> item = first;
        while (item != null) {
            sb.append(item);
            sb.append(item.isLast() ? "\n" : ",\n");
            item = item.getNext();
        }
        sb.append("]");
        System.out.println(sb);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private LinkedItem<E> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E result = current.getData();
                current = current.getNext();
                return result;
            }
        };
    }
}
