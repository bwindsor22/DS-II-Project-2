public class GraphMaker {

    public static UnweightedGraph graph1() {
        UnweightedGraph g = new UnweightedGraph();
        g.add();
        g.add();
        g.add();
        g.add();

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        return g;
    }

    public static UnweightedGraph graph2() {
        UnweightedGraph g = new UnweightedGraph();
        g.add();
        g.add();
        g.add();

        g.addEdge(0, 1);
        g.addEdge(2, 3);
        return g;
    }

    public static UnweightedGraph graph3() {
        UnweightedGraph g = new UnweightedGraph();
        g.add();
        g.add();
        g.add();
        g.add();
        g.add();

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 0);
        return g;
    }

    public static UnweightedGraph graph4() {
        UnweightedGraph g = new UnweightedGraph();
        for(int i = 0; i < 9; i++)
            g.add();

        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(3, 2);
        g.addEdge(3, 6);
        g.addEdge(0, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 7);
        g.addEdge(7, 8);
        return g;
    }

    public static UnweightedGraph graph5() {
        UnweightedGraph g = graph4();
        g.addEdge(4, 7);
        return g;
    }

    public static UnweightedGraph graph6() {
        UnweightedGraph g = new UnweightedGraph();
        for(int i = 0; i < 9; i++)
            g.add();
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(4, 3);
        g.addEdge(3, 0);
        g.addEdge(0, 5);
        g.addEdge(5, 6);;
        g.addEdge(7, 8);
        g.addEdge(0, 7);
        return g;
    }
}
