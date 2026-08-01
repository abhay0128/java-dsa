package Graphs;

import java.util.*;

public class BridgeTrajansAlgo {

    private int time = 0;

    public void findBridges(Map<String, List<String>> adj) {

        Set<String> visited = new HashSet<>();
        Map<String, Integer> disc = new HashMap<>();
        Map<String, Integer> low = new HashMap<>();
        Map<String, String> parent = new HashMap<>();

        for (String node : adj.keySet()) {
            if (!visited.contains(node)) {
                dfs(node, visited, disc, low, parent, adj);
            }
        }
    }

    private void dfs(String u,
                     Set<String> visited,
                     Map<String, Integer> disc,
                     Map<String, Integer> low,
                     Map<String, String> parent,
                     Map<String, List<String>> adj) {

        visited.add(u);
        disc.put(u, ++time);
        low.put(u, disc.get(u));

        for (String v : adj.getOrDefault(u, new ArrayList<>())) {
            if (!visited.contains(v)) {
                parent.put(v, u);
                dfs(v, visited, disc, low, parent, adj);

                // Update low[u]
                low.put(u, Math.min(low.get(u), low.get(v)));

                // Bridge condition
                if (low.get(v) > disc.get(u)) {
                    System.out.println("Bridge: " + u + " - " + v);
                }
            } else if (!v.equals(parent.get(u))) {
                // Back edge
                low.put(u, Math.min(low.get(u), disc.get(v)));
            }
        }
    }
}
