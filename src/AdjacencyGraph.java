/*
@ASSESSME.USERID: yc5185
@ASSESSME.AUTHOR: Yuyao Cai
@ASSESSME.DESCRIPTION: Week9 Day1
@ASSESSME.ANALYZE: YES
*/
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class AdjacencyGraph<E> implements Graph<E> {

    private final Map<E, Vertex<E>> vertices;

    public AdjacencyGraph() {
        this.vertices = new HashMap<>();
    }

    @Override
    public void add(E value) {
        vertices.putIfAbsent(value, new Vertex<>(value));
    }

    @Override
    public boolean contains(E value) {
        return vertices.containsKey(value);
    }

    @Override
    public int size() {
        return vertices.size();
    }

    @Override
    public void connectDirected(E a, E b) {
        Vertex<E> vA = vertices.get(a);
        Vertex<E> vB = vertices.get(b);
        if (vA != null && vB != null) {
            vA.connect(vB);
        }
    }

    @Override
    public void connectUndirected(E a, E b) {
        Vertex<E> vA = vertices.get(a);
        Vertex<E> vB = vertices.get(b);
        if (vA != null && vB != null) {
            vA.connect(vB);
            vB.connect(vA);
        }
    }

    @Override
    public boolean connected(E a, E b) {
        Vertex<E> vA = vertices.get(a);
        Vertex<E> vB = vertices.get(b);
        return vA != null && vB != null && vA.connected(vB);
    }

    @Override
    public boolean connect(E a, E b) {
        Vertex<E> vA = vertices.get(a);
        Vertex<E> vB = vertices.get(b);
        if (vA == null || vB == null) {
            return false;
        }
        boolean alreadyConnected = vA.connected(vB);
        vA.connect(vB);
        return !alreadyConnected;
    }
}