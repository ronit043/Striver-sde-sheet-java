package Day23;
import java.util.*;

// TC O(n + e); SC O(3n + e)
class Graph_DFS {
   void dfs(int node, boolean[] vis, List<List<Integer>> adj, List<Integer> ans) {
      ans.add(node);
      vis[node] = true;
      for (int nbr : adj.get(node)) if (!vis[nbr]) dfs(nbr, vis, adj, ans);
   }
   List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
      List<Integer> ans = new ArrayList<>();
      boolean[] vis = new boolean[V + 1];
      for (int i = 1; i <= V; i++) if (!vis[i]) dfs(i, vis, adj, ans);
      return ans;
   }
}