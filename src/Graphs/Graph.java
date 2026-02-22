package Graphs;

import java.util.*;

public class Graph<T> {
    private final HashMap<T, List<T>> adjList;
    private final boolean bidirection;

    public HashMap<T, List<T>> getAdjList() {
        return adjList;
    }

    public Graph(boolean bidirection) {
        adjList = new HashMap<>();
        this.bidirection = bidirection;
    }

    public void addVertex(T v) {
        adjList.put(v, new ArrayList<T>());
    }

    public void addEdge(T source, T destination) {
        if (!adjList.containsKey(source))
            addVertex(source);
        if (!adjList.containsKey(destination))
            addVertex(destination);
        adjList.get(source).add(destination);
        if (bidirection)
            adjList.get(destination).add(source);
    }

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>(true);
        graph.addEdge("usa", "maxico");
        graph.addEdge("maxico", "brazil");
        graph.addEdge("maxico", "canada");
        graph.addEdge("brazil", "chile");
        graph.addEdge("canada", "greenland");
        graph.addEdge("chile", "antarctica");
        graph.addEdge("greenland", "antarctica");
        graph.addEdge("antarctica", "nemo");

        for(Map.Entry<String, List<String>> val: graph.getAdjList().entrySet()) {
            System.out.println(val.getKey() +"-> "+val.getValue());
        }

       // GraphDFS.dfs(graph, "usa");
       // GraphBFS.bfs(graph, "usa");
        PrintAllPaths.printAllPaths(graph, "usa", "greenland", new HashSet<>(), new ArrayList<>());
        NumConnectedComponents.numberOfConnectedCompoenets(graph);
    }
}