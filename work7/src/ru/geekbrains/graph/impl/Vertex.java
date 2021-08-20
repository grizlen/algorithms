package ru.geekbrains.graph.impl;

import java.util.Objects;

public class Vertex<T> {

    private final T value;
    private boolean visited;

    public Vertex(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void reset() {
        visited = false;
    }

    public void setVisited() {
        this.visited =true;
    }

    public boolean isVisited() {
        return visited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(value, vertex.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
