# Project 2
In this project, you will implement graph traversals and an API that gives directions for travel between cities. 
The algorithms included are:

Unweighted graph:
1. Breadth first search
2. Depth first search

Weighted graph:

3. Dijkstra's Algorithm

There is also a common `Graph` interface for both the unweighted and weighted graphs to implement.

A test suite is provided which gives solutions to each algorithm.

### Unweighted Graph
The unweighted graph includes several methods to create new nodes and connections between nodes. 
`g.add()` creates a new node in the graph, and `g.addEdge(0, 1)` creates a new edge from node 0 to node 1.

The test cases in this class return a `List` of nodes traversed in order from source to target.
The below two lines indicate that on a breadth first search from node 0 to node 3, the nodes 0, 1, 2, and 3 are visited in order.
```
List<Integer> path = g.breadthFirstSearch(0, 3);
assertEquals(Arrays.asList(0, 1, 2, 3), path);
```

### Weighted Graph
The weighted graph is initialized from two JSON files. I recommend writing `Road` and `City` classes and using
an ObjectMapper to read the json files into a `Road[]` class. The `pom.xml` includes the maven dependency to import this library.

The test cases for this map return instances of a `Directions` class, which has a list of roads to take, in order,
and a total travel distance.

The below lines mean that the shortest path from city 2 to city 3 is 17 miles, 
traveling on Road 1-2 to Road 0-1 to Road 3-0.
```
Directions directions = findDirections(testName, 2, 3);

assertEquals(Arrays.asList("Road 1-2","Road 0-1","Road 3-0"), directions.getRoads());
assertEquals(17.468047080148757, directions.getTotalDistance(), 0.01);
```

Some of the larger test cases have highways that span between groups of closely linked nodes.

### Reference files
I have included the python files used to generate the test cases. No work is required with these files.

### Potentially useful pages:
https://www.baeldung.com/jackson-object-mapper-tutorial
https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html
https://en.wikipedia.org/wiki/Breadth-first_search
https://en.wikipedia.org/wiki/Depth-first_search
https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
