package ru.geekbrains;

import java.util.function.Consumer;

public interface Tree<E extends Comparable<? super E>> {

    enum TraversMode {
        IN_ORDER, PRE_ORDER, POST_ORDER
    }

    boolean add(E value);

    boolean contains(E value);

    void remove(E value);

    boolean isEmpty();

    int size();

    void display();

    void traverse(TraversMode mode, Consumer<Node<E>> consumer);

}
