import java.util.List;

public class Directions {
    List<String> roads;
    Double totalDistance = 0.0;

    public Directions(List<String> roads, Double totalDistance) {
        this.roads = roads;
        this.totalDistance = totalDistance;
    }

    public List<String> getRoads() {
        return roads;
    }

    public double getTotalDistance() {
        return totalDistance;
    }
}
