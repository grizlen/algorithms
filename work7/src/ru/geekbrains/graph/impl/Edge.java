package ru.geekbrains.graph.impl;

import java.util.Objects;

public class Edge<T> {

    private final Vertex<T> start;
    private final Vertex<T> end;

    public Edge(Vertex<T> start, Vertex<T> end) {
        this.start = start;
        this.end = end;
    }

    public Vertex<T> getStart() {
        return start;
    }

    public Vertex<T> getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return Objects.equals(start, edge.start) && Objects.equals(end, edge.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
