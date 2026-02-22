package Graphs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {

    public static void bfs(Graph<String> graph, String source) {
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(source);
        visited.add(source);
        int level = 0;
        while(!queue.isEmpty()) {
            int sz = queue.size();   // level size
            for(int i=0; i<sz; i++) {
                String curr = queue.poll();
                System.out.println(curr);

                for(String neighbour: graph.getAdjList().get(curr)) {
                    if(!visited.contains(neighbour)) {
                        queue.add(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            level++;
        }
    }
}
