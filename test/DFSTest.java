

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DFSTest {
    @Test
    public void testSimpleDFS() {
        UnweightedGraph g = GraphMaker.graph1();
        List<Integer> path = g.depthFirstSearch(0, 3);
        assertEquals(Arrays.asList(0, 1, 2, 3), path);
    }

    @Test
    public void testFailDFS() {
        UnweightedGraph g = GraphMaker.graph2();
        List<Integer> path = g.depthFirstSearch(0, 3);
        assertEquals(new ArrayList<>(), path);
    }

    @Test
    public void testDFSCircle(){
        UnweightedGraph g = GraphMaker.graph3();

        List<Integer> path = g.depthFirstSearch(0, 3);
        assertEquals(Arrays.asList(0, 1, 2, 3), path);
    }

    @Test
    public void testDFSMed() {
        UnweightedGraph g = GraphMaker.graph4();

        List<Integer> path = g.depthFirstSearch(0, 8);
        assertEquals(Arrays.asList(0, 1, 3, 6, 7, 8), path);
    }

    @Test
    public void testDFSMed2() {
        UnweightedGraph g = GraphMaker.graph5();

        List<Integer> path = g.depthFirstSearch(0, 8);
        assertEquals(Arrays.asList(0, 1, 3, 6, 5, 4, 7, 8), path);
    }

    @Test
    public void testDFSStar() {
        UnweightedGraph g = GraphMaker.graph6();

        List<Integer> path = g.depthFirstSearch(8, 6);
        assertEquals(Arrays.asList(8, 7, 0, 5, 6), path);
    }
}
