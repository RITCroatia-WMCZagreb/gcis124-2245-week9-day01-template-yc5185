/*
@ASSESSME.USERID: yc5185
@ASSESSME.AUTHOR: Yuyao Cai
@ASSESSME.DESCRIPTION: Week9 Day1
@ASSESSME.ANALYZE: YES
*/

import java.util.HashMap;
import java.util.Map;

public class Graphs {
    public static Graph<String> makeGraph() {
        Graph<String> graph = new AdjacencyGraph<>();
        
        // Add all vertices
        String[] vertices = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        for (String v : vertices) {
            graph.add(v);
        }

        // A connections
        graph.connectUndirected("A", "B");
        graph.connectDirected("A", "C");

        // B connections
        graph.connectDirected("B", "E");

        // C connections
        graph.connectUndirected("C", "D");
        graph.connectDirected("C", "E");
        graph.connectDirected("C", "H");

        // D connections
        graph.connectDirected("D", "B");
        graph.connectDirected("D", "F");

        // E connections
        graph.connectDirected("E", "F");

        // F connections
        graph.connectDirected("F", "G");

        // I, J, K connections
        graph.connectDirected("I", "K");
        graph.connectUndirected("J", "I");
        graph.connectUndirected("J", "K");

        return graph;
    }
}

class AdjacencyGraph<E> implements Graph<E> {
    private final Map<E, Vertex<E>> vertices = new HashMap<>();

    public void add(E value) {
        vertices.putIfAbsent(value, new Vertex<>(value));
    }

    public boolean contains(E value) {
        return vertices.containsKey(value);
    }

    public int size() {
        return vertices.size();
    }

    public void connectDirected(E a, E b) {
        Vertex<E> vA = vertices.get(a);
        Vertex<E> vB = vertices.get(b);
        vA.connect(vB);
    }

    public void connectUndirected(E a, E b) {
        Vertex<E> vA = vertices.get(a);
        Vertex<E> vB = vertices.get(b);
        vA.connect(vB);
        vB.connect(vA);
    }

    public boolean connected(E a, E b) {
        Vertex<E> vA = vertices.get(a);
        Vertex<E> vB = vertices.get(b);
        return vA != null && vB != null && vA.connected(vB);
    }

    public boolean connect(E a, E b) {
        Vertex<E> vA = vertices.get(a);
        Vertex<E> vB = vertices.get(b);
        boolean wasConnected = vA.connected(vB);
        vA.connect(vB);
        return !wasConnected;
    }
}