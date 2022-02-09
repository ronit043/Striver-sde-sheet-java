package Day23;

import java.util.List;

public class Detect_cycle_UG_DFS {
    public boolean dfs(int node, int par, boolean[] vis, List<List<Integer>> adj) {
        vis[node] = true;

        for (var nbr : adj.get(node)) {
            if (!vis[nbr])
                if (dfs(nbr, node, vis, adj)) return true;
            else if (nbr != par) return true;
        }

        return false;
    }

    // 0-based indexing Graph
    public boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i])
                if (dfs(i, -1, vis, adj)) return true;
        }

        return false;
    }
}