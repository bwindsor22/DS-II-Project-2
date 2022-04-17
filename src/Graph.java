import java.util.Set;

public abstract class Graph {
    abstract int nodesCount();

    abstract int edgesCount();

    abstract Set<Integer> neighboringNodes(int nodeNumber);
}
