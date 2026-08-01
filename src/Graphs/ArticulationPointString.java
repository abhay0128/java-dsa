package Graphs;

import java.util.*;

public class ArticulationPointString {

    private int time = 0;

    public void findArticulationPoints(Map<String, List<String>> adj) {

        Set<String> visited = new HashSet<>();
        Map<String, Integer> disc = new HashMap<>(); // Discovery time of each vertex
        Map<String, Integer> low = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        Set<String> articulationPoints = new HashSet<>();

        for (String node : adj.keySet()) {
            if (!visited.contains(node)) {
                dfs(node, visited, disc, low, parent, articulationPoints, adj);
            }
        }
        System.out.println("Articulation Points: " + articulationPoints);
    }

    private void dfs(String u,
                     Set<String> visited,
                     Map<String, Integer> disc,
                     Map<String, Integer> low,
                     Map<String, String> parent,
                     Set<String> articulationPoints,
                     Map<String, List<String>> adj) {

        visited.add(u);
        disc.put(u, ++time);
        low.put(u, disc.get(u));

        int childCount = 0;

        for (String v : adj.getOrDefault(u, new ArrayList<>())) {
            if (!visited.contains(v)) {
                parent.put(v, u);
                childCount++;

                dfs(v, visited, disc, low, parent, articulationPoints, adj);

                // Update low[u]
                low.put(u, Math.min(low.get(u), low.get(v)));

                // Case 2: non-root articulation condition
                if (parent.containsKey(u) && low.get(v) >= disc.get(u)) {
                    articulationPoints.add(u);
                }
            } else if (!v.equals(parent.get(u))) {
                // Back edge
                low.put(u, Math.min(low.get(u), disc.get(v)));
            }
        }

        // Case 1: root articulation condition
        if (!parent.containsKey(u) && childCount > 1) {
            articulationPoints.add(u);
        }
    }
}