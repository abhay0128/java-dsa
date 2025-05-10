package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class GrapgDFS {

    // Iterative
    public void dfs(Graph<String> graph, String source) {
        Stack<String> stack = new Stack<>();
        stack.push(source);
        Set<String> visited = new HashSet<>();

        while(!stack.isEmpty()) {
            String curr = stack.pop();
            if(!visited.contains(curr)) {
                visited.add(curr);
                System.out.print(curr+" ");

                for (String neighbour : graph.getAdjList().get(curr)) {
                    if(!visited.contains(neighbour)) {
                        stack.push(neighbour);
                    }
                }
            }
        }
    }

    // Recursive
    public void dfs(Graph<Integer> graph, int source, Set<Integer> visited) {
        if(visited.contains(source)) return;
        visited.add(source);
        System.out.println(source);

        for (int neighbour: graph.getAdjList().getOrDefault(source, new ArrayList<>())) {
            dfs(graph, neighbour, visited);
        }
    }
}
