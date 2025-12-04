package Graphs;

import java.util.*;

public class PrimsAlgo {

    static class Edge {
        String dest;
        int weight;

        Edge(String dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void primMST(Map<String, List<Edge>> graph, String start) {
        Set<String> visited = new HashSet<>();
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        visited.add(start);
        minHeap.addAll(graph.get(start));
        int mstCost = 0;

        while (!minHeap.isEmpty()) {
            Edge e = minHeap.poll();
            if (!visited.contains(e.dest)) {
                visited.add(e.dest);
                mstCost += e.weight;
                System.out.println("Edge to " + e.dest + " with weight " + e.weight);
                for (Edge next : graph.get(e.dest)) {
                    if (!visited.contains(next.dest)) {
                        minHeap.add(next);
                    }
                }
            }
        }

        System.out.println("Total cost of MST: " + mstCost);
    }

    public static void main(String[] args) {
        Map<String, List<Edge>> graph = new HashMap<>();
        graph.put("A", Arrays.asList(new Edge("B", 4), new Edge("C", 2)));
        graph.put("B", Arrays.asList(new Edge("A", 4), new Edge("C", 5), new Edge("D", 10)));
        graph.put("C", Arrays.asList(new Edge("A", 2), new Edge("B", 5), new Edge("D", 3)));
        graph.put("D", Arrays.asList(new Edge("B", 10), new Edge("C", 3)));

        primMST(graph, "A");
    }

}
