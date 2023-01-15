package Day23;
import java.util.*;

class Topological_Sort_DFS {
   static int[] topoSort(int V, List<List<Integer>> adj) {
      boolean[] vis = new boolean[V];
      List<Integer> al = new ArrayList<>();
      Deque<Integer> stq = new ArrayDeque<>();

      for (int i = 0; i < V; ++i) if (!vis[i]) dfs(adj, vis, stq, i);
      while (!stq.isEmpty()) al.add(stq.pop());

      return al.stream().mapToInt(i -> i).toArray();
   }

   static void dfs(List<List<Integer>> adj, boolean[] vis, Deque<Integer> stq, int node) {
      vis[node] = true;
      for (var nbr : adj.get(node)) if (!vis[nbr]) dfs(adj, vis, stq, node);
      stq.push(node);
   }
}
