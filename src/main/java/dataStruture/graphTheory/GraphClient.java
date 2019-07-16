package dataStruture.graphTheory;

public class GraphClient {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        System.out.println("Visits:");
        graph.dfs();
        System.out.println();
        graph.bfs();

        System.out.println();
        System.out.println("=========================");
        Graph graph1 = new Graph();
        graph1.addVertex("A");
        graph1.addVertex("B");
        graph1.addVertex("C");
        graph1.addVertex("D");
        graph1.addVertex("E");

        graph1.addEdge(0,1);
        graph1.addEdge(0,2);
        graph1.addEdge(0,3);
        graph1.addEdge(0,4);
        graph1.addEdge(1,2);
        graph1.addEdge(1,3);
        graph1.addEdge(1,4);
        graph1.addEdge(2,3);
        graph1.addEdge(2,4);
        graph1.addEdge(3,4);

        graph1.mst();
    }
}
