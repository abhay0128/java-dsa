package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class TopogoicalSort {

    public static void topologicalSort(Graph<String> graph) {
        HashSet<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();

        for(String node: graph.getAdjList().keySet()) {
            if(!visited.contains(node)) {
                topologicalSortUtil(graph, node, visited, stack);
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }

    public static void topologicalSortUtil(Graph<String> graph, String current, HashSet<String> visited, Stack<String> stack) {
        visited.add(current);

        for(String neighbour: graph.getAdjList().getOrDefault(current, new ArrayList<>())) {
            if(!visited.contains(neighbour)) {
                topologicalSortUtil(graph, neighbour, visited, stack);
            }
        }

        stack.push(current);
    }
}
