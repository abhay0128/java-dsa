package Graphs;
import java.util.*;

public class BellmanFord {

    static class Edge {
        String src, dest;
        int weight;

        Edge(String s, String d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void bellmanFord(List<Edge> edges, Set<String> vertices, String src) {
        Map<String, Integer> dist = new HashMap<>();

        // Initialize distances
        for (String v : vertices) {
            dist.put(v, Integer.MAX_VALUE);
        }
        dist.put(src, 0);

        int V = vertices.size();

        // Relax edges |V| - 1 times
        for (int i = 1; i < V; i++) {
            for (Edge e : edges) {
                if (dist.get(e.src) != Integer.MAX_VALUE &&
                        dist.get(e.src) + e.weight < dist.get(e.dest)) {
                    dist.put(e.dest, dist.get(e.src) + e.weight);
                }
            }
        }

        // Check for negative weight cycles
        for (Edge e : edges) {
            if (dist.get(e.src) != Integer.MAX_VALUE &&
                    dist.get(e.src) + e.weight < dist.get(e.dest)) {
                System.out.println("Graph contains a negative weight cycle");
                return;
            }
        }

        // Print shortest paths
        for (String v : vertices) {
            System.out.println("Distance from " + src + " to " + v + ": " + dist.get(v));
        }
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge("A", "B", 4));
        edges.add(new Edge("B", "C", -5));
        edges.add(new Edge("A", "C", 2));

        Set<String> vertices = new HashSet<>(Arrays.asList("A", "B", "C"));

        bellmanFord(edges, vertices, "A");
    }

}
