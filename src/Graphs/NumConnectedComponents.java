package Graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class NumConnectedComponents {

    public static int numberOfConnectedCompoenets(Graph<String> graph) {
        HashSet<String> visited = new HashSet<>();
        int count = 0;
        for(String node: graph.getAdjList().keySet()) {
            if(explore(graph, node, visited)) {
                count++;
            }
        }
        System.out.println("Number of connected components: "+count);
        return count;
    }

    public static boolean explore(Graph<String> graph, String current, HashSet<String> visited) {
        if(visited.contains(current)) {
            return false;
        }
        visited.add(current);
        for(String neighbour: graph.getAdjList().getOrDefault(current, new ArrayList<>())) {
            explore(graph, neighbour, visited);
        }
        return true;
    }
}
