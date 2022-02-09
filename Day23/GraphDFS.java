package Day23;

import java.util.ArrayList;
import java.util.List;

// TC O(n + e); SC O(3n + e)
public class GraphDFS {
    void dfs(int node, boolean[] vis, List<List<Integer>> adj, List<Integer> ans) {
        ans.add(node);
        vis[node] = true;

        for (int child : adj.get(node))
            if (!vis[child]) dfs(child, vis, adj, ans);
    }

    List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V + 1];

        for (int i = 1; i <= V; i++)
            if (!vis[i]) dfs(i, vis, adj, ans);

        return ans;
    }
}