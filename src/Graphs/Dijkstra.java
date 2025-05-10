package Graphs;

import java.util.*;

public class Dijkstra {

    static class Edge {
        String dest;
        int weight;

        Edge(String dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void dijkstra(Map<String, List<Edge>> graph, String src) {
        Map<String, Integer> dist = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        Set<String> visited = new HashSet<>();

        // Initialize distances
        for (String node : graph.keySet()) {
            dist.put(node, Integer.MAX_VALUE);
        }
        dist.put(src, 0);
        pq.offer(new AbstractMap.SimpleEntry<>(src, 0));

        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> currentEntry = pq.poll();
            String current = currentEntry.getKey();

            if (visited.contains(current)) continue;
            visited.add(current);

            for (Edge e : graph.get(current)) {
                if (!visited.contains(e.dest)) {
                    int newDist = dist.get(current) + e.weight;
                    if (newDist < dist.get(e.dest)) {
                        dist.put(e.dest, newDist);
                        pq.offer(new AbstractMap.SimpleEntry<>(e.dest, newDist));
                    }
                }
            }
        }

        // Print shortest paths
        for (String node : dist.keySet()) {
            System.out.println("Distance from " + src + " to " + node + " is " + dist.get(node));
        }
    }

    public static void main(String[] args) {
        Map<String, List<Edge>> graph = new HashMap<>();

        graph.put("A", Arrays.asList(new Edge("B", 4), new Edge("C", 1)));
        graph.put("B", Arrays.asList(new Edge("D", 1)));
        graph.put("C", Arrays.asList(new Edge("B", 2), new Edge("D", 5)));
        graph.put("D", new ArrayList<>());

        dijkstra(graph, "A");
    }
}
