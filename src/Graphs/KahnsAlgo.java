package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class KahnsAlgo {

    public static void topSortKahn(Graph<String> graph) {
        HashMap<String, Integer> inDegree = new HashMap<>();

        int count=0;
        // Initialize indegree = 0
        for(String node: graph.getAdjList().keySet()) {
            inDegree.put(node, 0);
        }

        // Calculate indegree
        for(String node: graph.getAdjList().keySet()) {
            for(String neighbour: graph.getAdjList().getOrDefault(node, new ArrayList<>())) {
                inDegree.put(neighbour, inDegree.getOrDefault(neighbour, 0)+1);
            }
        }

        ArrayDeque<String> queue = new ArrayDeque<>();
        // Add nodes with indegree 0
        for (String node : inDegree.keySet()) {
            if (inDegree.get(node) == 0) {
                queue.offer(node);
            }
        }

        while(!queue.isEmpty()) {
            String curr = queue.poll();
            System.out.print(curr+" ");
            count++;

            for(String neighbour: graph.getAdjList().getOrDefault(curr, new ArrayList<>())) {
                inDegree.put(neighbour, inDegree.get(neighbour)-1);
                if(inDegree.get(neighbour) == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        if(count!=inDegree.size()) {
            System.out.println("Graph has a cycle, topological sort not possible");
        }
    }
}
