import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DijkstraTest {
    @Test
    public void test4_0() throws IOException {
        String testName = "nodes-4-num-0";
        String citiesFile = FileUtil.getCitiesFile(testName);
        String roadsFile = FileUtil.getRoadsFile(testName);

        WeightedGraph g = new WeightedGraph(citiesFile, roadsFile);
        Directions directions = g.findShortestPath(1, 3);

        assertEquals(Arrays.asList("Road 1-2","Road 0-2","Road 3-0"), directions.getRoads());
        assertEquals(12.670630037921647, directions.getTotalDistance(), 0.01);

        // run in reverse
        directions = g.findShortestPath(3, 1);

        assertEquals(Arrays.asList("Road 3-0", "Road 0-2", "Road 1-2"), directions.getRoads());
        assertEquals(12.670630037921647, directions.getTotalDistance(), 0.01);
    }

    @Test
    public void test4_1() throws IOException {
        String testName = "nodes-4-num-1";

        Directions directions = findDirections(testName, 2, 3);

        assertEquals(Arrays.asList("Road 1-2","Road 0-1","Road 3-0"), directions.getRoads());
        assertEquals(17.468047080148757, directions.getTotalDistance(), 0.01);
    }

    @Test
    public void test4_2() throws IOException {
        String testName = "nodes-4-num-2";

        Directions directions = findDirections(testName, 1, 3);

        assertEquals(Arrays.asList("Road 1-0","Road 0-2","Road 2-3"), directions.getRoads());
        assertEquals(11.095485061609887, directions.getTotalDistance(), 0.01);
    }

    @Test
    public void test4_3() throws IOException {
        String testName = "nodes-4-num-3";

        Directions directions = findDirections(testName, 2, 0);

        assertEquals(Arrays.asList("Road 3-2","Road 0-3"), directions.getRoads());
        assertEquals(7.655065891341617, directions.getTotalDistance(), 0.01);
    }

    @Test
    public void test4_4() throws IOException {
        String testName = "nodes-4-num-4";

        Directions directions = findDirections(testName, 2, 1);

        assertEquals(Arrays.asList("Road 2-3","Road 0-3","Road 1-0"), directions.getRoads());
        assertEquals(18.8557675454308, directions.getTotalDistance(), 0.01);
    }

    @Test
    public void test10_0() throws IOException {
        String testName = "nodes-10-num-0";

        Directions directions = findDirections(testName, 3, 6);

        assertEquals(Arrays.asList("Road 5-3","Road 0-5","Highway 0-4","Road 4-6"), directions.getRoads());
        assertEquals(128.46435184752622, directions.getTotalDistance(), 0.01);
    }


    @Test
    public void test10_1() throws IOException {
        String testName = "nodes-10-num-1";

        Directions directions = findDirections(testName, 6, 9);

        assertEquals(Arrays.asList("Road 6-1","Road 1-7","Road 4-7","Road 4-3","Road 3-2","Road 2-9"), directions.getRoads());
        assertEquals(134.8414923323245, directions.getTotalDistance(), 0.01);
    }

    @Test
    public void test10_2() throws IOException {
        String testName = "nodes-10-num-2";

        Directions directions = findDirections(testName, 4, 9);

        assertEquals(Arrays.asList("Road 4-3","Road 3-2","Road 1-2","Road 7-1","Road 9-7"), directions.getRoads());
        assertEquals(233.74437632017992, directions.getTotalDistance(), 0.01);
    }

    @Test
    public void test10_3() throws IOException {
        String testName = "nodes-10-num-3";

        Directions directions = findDirections(testName, 2, 4);

        assertEquals(Arrays.asList("Road 2-5","Road 5-6","Road 1-6","Road 9-1","Road 7-9","Road 7-0","Road 0-4"), directions.getRoads());
        assertEquals(247.82125892252978, directions.getTotalDistance(), 0.01);
    }

    @Test
    public void test10_4() throws IOException {
        String testName = "nodes-10-num-4";

        Directions directions = findDirections(testName, 4, 5);

        assertEquals(Arrays.asList("Road 4-1","Highway 0-1","Road 0-5"), directions.getRoads());
        assertEquals(133.14537103351427, directions.getTotalDistance(), 0.01);
    }

    @Test
    public void test100_0() throws IOException {
        String testName = "nodes-100-num-0";

        Directions directions = findDirections(testName, 11, 88);

        assertEquals(Arrays.asList("Road 94-11","Road 9-94","Road 13-9","Road 13-32","Road 98-32","Road 33-98","Road 68-33","Road 29-68","Road 29-72","Road 72-16","Road 16-39","Road 88-39"),
                directions.getRoads());
        assertEquals(1691.1752875436189, directions.getTotalDistance(), 0.01);
    }

    @Test
    public void test100_1() throws IOException {
        String testName = "nodes-100-num-1";

        Directions directions = findDirections(testName, 10, 46);

        assertEquals(Arrays.asList("Road 10-66","Road 89-66","Road 89-59","Road 59-55","Road 67-55","Road 56-67","Road 56-35","Road 74-35","Road 97-74","Road 43-97","Road 43-92","Road 87-92","Road 13-87","Road 13-52","Road 30-52","Road 46-30"),
                directions.getRoads());
        assertEquals(1679.026128208437, directions.getTotalDistance(), 0.01);
    }

    @Test
    public void test100_2() throws IOException {
        String testName = "nodes-100-num-2";

        Directions directions = findDirections(testName, 71, 50);

        assertEquals(Arrays.asList("Road 58-71","Road 10-58","Road 96-10","Road 96-82","Road 82-83","Road 53-83","Road 1-53","Road 1-33","Road 67-33","Road 67-2","Road 28-2","Road 28-50"),
                directions.getRoads());
        assertEquals(1610.095812815558, directions.getTotalDistance(), 0.01);
    }

    @Test
    public void test100_3() throws IOException {
        String testName = "nodes-100-num-3";

        Directions directions = findDirections(testName, 70, 81);

        assertEquals(Arrays.asList("Road 70-95","Road 88-95","Road 88-16","Road 16-43","Road 43-51","Road 99-51","Road 99-97","Road 15-97","Road 15-37","Road 30-37","Road 30-54","Road 54-10","Road 57-10","Road 57-82","Road 81-82"),
                directions.getRoads());
        assertEquals(1674.1770279699592, directions.getTotalDistance(), 0.01);
    }

    @Test
    public void test100_4() throws IOException {
        String testName = "nodes-100-num-4";

        Directions directions = findDirections(testName, 80, 49);

        assertEquals(Arrays.asList("Road 80-45","Road 1-45","Highway 0-1","Road 84-0","Road 84-46","Road 6-46","Road 6-44","Road 77-44","Road 22-77","Road 10-22","Road 10-55","Road 17-55","Road 17-91","Road 91-82","Road 82-49"),
                directions.getRoads());
        assertEquals(1752.5189235283483, directions.getTotalDistance(), 0.01);
    }


    Directions findDirections(String testName, int startCity, int endCity) throws IOException {
        String citiesFile = FileUtil.getCitiesFile(testName);
        String roadsFile = FileUtil.getRoadsFile(testName);

        WeightedGraph g = new WeightedGraph(citiesFile, roadsFile);
        return g.findShortestPath(startCity, endCity);
    }

}
