package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PrintAllPaths {

    public static void printAllPaths(Graph<String> graph, String source, String destination, Set<String> visited, List<String> path) {
        visited.add(source);
        path.add(source);

        if(source.equals(destination)) {
            System.out.println(String.join("->", path));
        }

        for(String neighbour: graph.getAdjList().getOrDefault(source, new ArrayList<>())) {
            if(!visited.contains(neighbour)) {
                printAllPaths(graph, neighbour, destination, visited, path);
            }
        }

        visited.remove(source);
        path.removeLast();

    }
}
