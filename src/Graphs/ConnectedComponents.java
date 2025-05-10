package Graphs;

import java.util.HashSet;
import java.util.Set;

public class ConnectedComponents {

    public static int numberOfConnectedCompoenets(Graph<String> graph) {
        HashSet<String> visited = new HashSet<>();
        int count = 0;
        for(String node: graph.getAdjList().keySet()) {
            if(explore(graph, node, visited)) {
                count++;
            }
        }
        return count;
    }

    private static boolean explore(Graph<String> graph, String current, HashSet<String> visited) {
        if(visited.contains(current)) {
            return false;
        }
        visited.add(current);
        for(String neighbour: graph.getAdjList().get(current)) {
            explore(graph, neighbour, visited);
        }
        return true;
    }

}
