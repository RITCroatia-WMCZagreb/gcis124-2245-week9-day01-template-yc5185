/*
@ASSESSME.USERID: yc5185
@ASSESSME.AUTHOR: Yuyao Cai
@ASSESSME.DESCRIPTION: Week9 Day1
@ASSESSME.ANALYZE: YES
*/

public interface Graph<E> {
    void add(E value);
    boolean contains(E value);
    int size();
    void connectDirected(E a, E b);
    void connectUndirected(E a, E b);
    boolean connect(E a, E b);
}
