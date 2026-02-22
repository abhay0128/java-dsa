package Graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class CycleDetectionDirected {

    public static boolean isCycleDirected(Graph<String> graph) {
        HashSet<String> visited = new HashSet<>();
        HashSet<String> recStack = new HashSet<>();

        for(String node: graph.getAdjList().keySet()) {
            if(isCycleDirectedUtil(graph, node, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCycleDirectedUtil(Graph<String> graph, String current, HashSet<String> visited, HashSet<String> recStack) {
        if(recStack.contains(current)) {
            return true;
        }
        if(visited.contains(current)) {
            return false;
        }

        visited.add(current);
        recStack.add(current);

        for(String neighbour: graph.getAdjList().getOrDefault(current, new ArrayList<>())) {
            if(isCycleDirectedUtil(graph, neighbour, visited, recStack)) {
                return true;
            }
        }

        recStack.remove(current);
        return false;
    }
}
