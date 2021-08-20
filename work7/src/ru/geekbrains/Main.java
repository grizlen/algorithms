package ru.geekbrains;

import ru.geekbrains.graph.impl.Edge;
import ru.geekbrains.graph.impl.GraphImpl;
import ru.geekbrains.graph.impl.Vertex;

public class Main {

    public static void main(String[] args) {
        GraphImpl<String> graph = new GraphImpl<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        Vertex<String> vertexA = graph.findVertex("A");
        Vertex<String> vertexB = graph.findVertex("B");
        Vertex<String> vertexC = graph.findVertex("C");
        Vertex<String> vertexD = graph.findVertex("D");
        Vertex<String> vertexE = graph.findVertex("E");
        Vertex<String> vertexF = graph.findVertex("F");
        Vertex<String> vertexG = graph.findVertex("G");
        Vertex<String> vertexH = graph.findVertex("H");

        graph.addEdges(
                new Edge<String>(vertexA, vertexB),
                new Edge<String>(vertexA, vertexC),
                new Edge<String>(vertexA, vertexD),
                new Edge<String>(vertexB, vertexA),
                new Edge<String>(vertexB, vertexE),
                new Edge<String>(vertexC, vertexA),
                new Edge<String>(vertexC, vertexF),
                new Edge<String>(vertexD, vertexA),
                new Edge<String>(vertexD, vertexG),
                new Edge<String>(vertexE, vertexB),
                new Edge<String>(vertexE, vertexH),
                new Edge<String>(vertexF, vertexC),
                new Edge<String>(vertexG, vertexD),
                new Edge<String>(vertexH, vertexE)
        );
        graph.display();
        System.out.println("DFS:");
        graph.dfs("A");
        System.out.println("BFS:");
        graph.bfs("A");
        System.out.println(graph.findShortPathViaBfs("A", "H").toString());
    }
}
