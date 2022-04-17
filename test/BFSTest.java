
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BFSTest {

    @Test
    public void testSimpleBFS() {
        UnweightedGraph g = GraphMaker.graph1();
        Assert.assertEquals(4, g.nodesCount());
        List<Integer> path = g.breadthFirstSearch(0, 3);
        assertEquals(Arrays.asList(0, 1, 2, 3), path);
    }

    @Test
    public void testFailBFS() {
        UnweightedGraph g = GraphMaker.graph2();
        List<Integer> path = g.breadthFirstSearch(0, 3);
        assertEquals(new ArrayList<>(), path);
    }

    @Test
    public void testBFSCircle(){
        UnweightedGraph g = GraphMaker.graph3();

        List<Integer> path = g.breadthFirstSearch(0, 3);
        assertEquals(Arrays.asList(0, 4, 3), path);
    }

    @Test
    public void testBFSMed() {
        UnweightedGraph g = GraphMaker.graph4();

        List<Integer> path = g.breadthFirstSearch(0, 8);
        assertEquals(Arrays.asList(0, 1, 3, 6, 7, 8), path);
    }

    @Test
    public void testBFSMed2() {
        UnweightedGraph g = GraphMaker.graph5();

        List<Integer> path = g.breadthFirstSearch(0, 8);
        assertEquals(Arrays.asList(0, 4, 7, 8), path);
    }

    @Test
    public void tesBFSStar() {
        UnweightedGraph g = GraphMaker.graph6();

        List<Integer> path = g.breadthFirstSearch(8, 6);
        assertEquals(Arrays.asList(8, 7, 0, 5, 6), path);
    }
}