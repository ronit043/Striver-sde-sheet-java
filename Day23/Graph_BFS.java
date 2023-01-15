package Day23;
import java.util.*;

// TC O(n + 2e); SC O(n)
class Graph_BFS {
   List<Integer> BFS(List<List<Integer>> adj, int V) {
      boolean[] vis = new boolean[V + 1];
      Queue<Integer> q = new ArrayDeque<>();
      List<Integer> bfs = new ArrayList<>();

      // Push this item to the queue, set vis to true so that we don't encounter an item again
      q.add(0);
      vis[0] = true;

      while (!q.isEmpty()) {
         int node = q.poll();
         bfs.add(node);
         // Go to adjacent vertices, add 'em to the q if unvisited
         for (int nbr : adj.get(node))
            if (!vis[nbr]) { vis[nbr] = true; q.add(nbr); }
      }

      return bfs;
   }
}