package ru.geekbrains.graph;

import ru.geekbrains.graph.impl.Edge;
import ru.geekbrains.graph.impl.Vertex;

import java.util.Stack;

public interface Graph<E> {
    boolean addVertex(E value);
    boolean addEdges(Edge<E>... edges);
    int getSize();
    void display();
    /**
     * англ. Depth-first search, DFS
     * @param start
     */
    void dfs(E start);
    /**
     * англ. breadth-first search, BFS
     */
    void bfs(E start);
    Stack<Vertex<E>> findShortPathViaBfs(E start, E finish);
}
