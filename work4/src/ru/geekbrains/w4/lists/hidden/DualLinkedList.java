package ru.geekbrains.w4.lists.hidden;

public class DualLinkedList<E> extends LinkedList<E> {

    private DualLinkedItem<E> last;

    protected void setFirst(DualLinkedItem<E> item) {
        DualLinkedItem<E> first = (DualLinkedItem<E>) getFirst();
        if (first != null) {
            first.setPrev(item);
        }
        super.setFirst(item);
        if (item.isLast()) {
            last = item;
        }
    }

    private void setLast(DualLinkedItem<E> item) {
        last.setNext(item);
        last = item;
    }

    @Override
    public void insertFirst(E value) {
        setFirst(new DualLinkedItem<>(value, (DualLinkedItem<E>) getFirst(), null));
    }

    public void insertLast(E value) {
        if (last == null) {
            insertFirst(value);
        } else {
            setLast(new DualLinkedItem<>(value, null, last));
        }
    }

    @Override
    public E deleteFirst() {
        E result = super.deleteFirst();
        DualLinkedItem<E> first = (DualLinkedItem<E>) getFirst();
        if (first != null) {
            first.setPrev(null);
        } else {
            last = null;
        }
        return result;
    }

    public E deleteLast() {
        E result = last != null ? last.getData() : null;
        if (last != null) {
            last = last.getPrev();
        }
        if (last != null) {
            last.setNext(null);
        } else {
            super.setFirst(null);
        }
        return result;
    }
}
