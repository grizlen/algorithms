package ru.geekbrains.graph.impl;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class EdgeList<E> {

    private final ArrayList<Edge<E>> edges;

    public EdgeList() {
        edges = new ArrayList<Edge<E>>();
    }

    public boolean insert(Edge<E> edge) {
        if (!edges.contains(edge)) {
            edges.add(edge);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return edges.stream().map(edge -> edge.getEnd().getValue().toString())
                .collect(Collectors.joining(" => "));
    }

    public Vertex<E> getUnvisited() {
        return edges.stream().filter(edge -> !edge.getEnd().isVisited()).map(Edge::getEnd).findFirst().orElse(null);
    }

    public boolean containsEndVertex(Vertex<E> vertex) {
        return edges.stream().filter(edge -> edge.getEnd().equals(vertex)).count() != 0;
    }
}
