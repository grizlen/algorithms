package ru.geekbrains.graph.impl;

import ru.geekbrains.graph.Graph;

import java.util.*;

public class GraphImpl<E> implements Graph<E> {

    private final Map<Vertex<E>, EdgeList<E>> data;

    public GraphImpl() {
        data = new HashMap<>();
    }

    @Override
    public boolean addVertex(E value) {
        if (value == null) {
            return false;
        }
        Vertex<E> vertex = new Vertex<>(value);
        if (data.containsKey(vertex)) {
            return false;
        }
        data.put(vertex, new EdgeList<>());
        return true;
    }

    @Override
    public boolean addEdges(Edge<E>... edges) {
        boolean result = edges.length > 0;
        for (Edge<E> edge : edges) {
            if (data.containsKey(edge.getStart()) && data.containsKey(edge.getEnd())) {
                result &= data.get(edge.getStart()).insert(edge);
            }
        }
        return result;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public void display() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Vertex<E>, EdgeList<E>> entry : data.entrySet()) {
            sb.append(entry.getKey().getValue())
                    .append(" => ")
                    .append(entry.getValue())
                    .append("\n");
        }
        System.out.println(sb);
    }

    @Override
    public void dfs(E start) {
        Vertex<E> vertex = findVertex(start);
        if (vertex == null) {
            return;
        }
        reset();
        Stack<Vertex<E>> stack = new Stack<>();
        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNextUnvisited(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
    }

    @Override
    public void bfs(E start) {
        Vertex<E> vertex = findVertex(start);
        if (vertex == null) {
            return;
        }
        reset();
        Queue<Vertex<E>> queue = new LinkedList<>();
        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNextUnvisited(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
    }

    @Override
    public Stack<Vertex<E>> findShortPathViaBfs(E start, E finish) {
        Vertex<E> vertex = findVertex(start);
        Vertex<E> finishVertex = findVertex(finish);
        if (vertex == null || finishVertex == null) {
            return null;
        }
        reset();
        Queue<Vertex<E>> queue = new LinkedList<>();
        Stack<Vertex<E>> tmp = new Stack<>();
        tmp.push(vertex);
        queue.add(vertex);
        vertex.setVisited();
        while (!queue.isEmpty()) {
            vertex = getNextUnvisited(queue.peek());
            if (vertex == null) {
                queue.remove();
            } else {
                if (vertex.equals(finishVertex)) {
                    break;
                }
                tmp.push(vertex);
                queue.add(vertex);
                vertex.setVisited();
            }
        }
        Stack<Vertex<E>> result = new Stack<>();
        result.push(finishVertex);
        while (!tmp.isEmpty()) {
            vertex = tmp.pop();
            if (data.get(vertex).containsEndVertex(result.peek())) {
                result.push(vertex);
            }
        }
        return result;
    }

    public Vertex<E> findVertex(E value) {
        return data.entrySet().stream()
                .filter(entry -> entry.getKey().getValue().equals(value))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    private void reset() {
        data.keySet().forEach(vertex -> vertex.reset());
    }

    private void visitVertex(Stack<Vertex<E>> stack, Vertex<E> vertex) {
        System.out.println(vertex);
        stack.push(vertex);
        vertex.setVisited();
    }

    private void visitVertex(Queue<Vertex<E>> queue, Vertex<E> vertex) {
        System.out.println(vertex);
        queue.add(vertex);
        vertex.setVisited();
    }

    private Vertex<E> getNextUnvisited(Vertex<E> vertex) {
        return data.get(vertex).getUnvisited();
    }
}
