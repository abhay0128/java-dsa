package Graphs;


import java.util.*;

public class KosarajuAlgo {

    // Step 1: Normal DFS to fill order
    public static void dfs(String node, Set<String> visited, Stack<String> stack, Map<String, List<String>> graph) {
        visited.add(node);
        for (String nei : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(nei)) {
                dfs(nei, visited, stack, graph);
            }
        }
        stack.push(node);
    }

    // Step 2: Transpose the graph
    public static Map<String, List<String>> transposeGraph(Map<String, List<String>> graph) {
        Map<String, List<String>> transposed = new HashMap<>();
        for (String u : graph.keySet()) {
            for (String v : graph.get(u)) {
                transposed.computeIfAbsent(v, x -> new ArrayList<>()).add(u);
            }
        }
        return transposed;
    }

    // Step 3: DFS on transposed graph
    public static void dfsTranspose(String node, Set<String> visited, Map<String, List<String>> transposed, List<String> scc) {
        visited.add(node);
        scc.add(node);
        for (String nei : transposed.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(nei)) {
                dfsTranspose(nei, visited, transposed, scc);
            }
        }
    }

    public static void kosaraju(Map<String, List<String>> graph) {
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();

        // Step 1
        for (String node : graph.keySet()) {
            if (!visited.contains(node)) {
                dfs(node, visited, stack, graph);
            }
        }

        // Step 2
        Map<String, List<String>> transposed = transposeGraph(graph);

        // Step 3
        visited.clear();
        while (!stack.isEmpty()) {
            String node = stack.pop();
            if (!visited.contains(node)) {
                List<String> scc = new ArrayList<>();
                dfsTranspose(node, visited, transposed, scc);
                System.out.println("SCC: " + scc);
            }
        }
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B"));
        graph.put("B", Arrays.asList("C"));
        graph.put("C", Arrays.asList("A", "D"));
        graph.put("D", Arrays.asList("E"));
        graph.put("E", Arrays.asList("F"));
        graph.put("F", Arrays.asList("D"));

        kosaraju(graph);
    }
}
