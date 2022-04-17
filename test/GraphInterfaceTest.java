import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class GraphInterfaceTest {
    @Test
    public void testUnweighted() throws IOException {
        Graph g = GraphMaker.graph1();
        Assert.assertEquals(4, g.nodesCount());
        Assert.assertEquals(3, g.edgesCount());
        Set<Integer> neighbors = new HashSet<>(Arrays.asList(1, 3));
        Assert.assertEquals(neighbors, g.neighboringNodes(2));
    }

    @Test
    public void testWeighted() throws IOException {
        Graph g = new WeightedGraph(
                FileUtil.getCitiesFile("nodes-4-num-0"),
                FileUtil.getRoadsFile("nodes-4-num-0"));
        Assert.assertEquals(4, g.nodesCount());
        Assert.assertEquals(3, g.edgesCount());
        Set<Integer> neighbors = new HashSet<>(Arrays.asList(0, 1));
        Assert.assertEquals(neighbors, g.neighboringNodes(2));
    }

}
