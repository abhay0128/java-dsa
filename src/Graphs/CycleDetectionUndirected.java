package Graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class CycleDetectionUndirected {

    public static boolean isCycleUndirected(Graph<String> graph) {
        HashSet<String> visited = new HashSet<>();

        for(String node: graph.getAdjList().keySet()) {
            if(!visited.contains(node) && isCycleUndirectedUtil(graph, node, visited, null)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCycleUndirectedUtil(Graph<String> graph, String current, HashSet<String> visited, String parent) {
        visited.add(current);

        for(String neighbour: graph.getAdjList().getOrDefault(current, new ArrayList<>())) {
            if(!visited.contains(neighbour)) {
                if(isCycleUndirectedUtil(graph, neighbour, visited, current)) {
                    return true;
                }
            } else if(!neighbour.equals(parent)) {
                return true;
            }
        }

        return false;
    }
}
