package Day23;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Topological_Sort_BFS {
   public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
      int[] inDegree = new int[V];
      List<Integer> order = new ArrayList<>();
      Queue<Integer> q = new ArrayDeque<>();

      for (int i = 0; i < V; i++)
         for (int j : adj.get(i)) inDegree[j]++;

      for (int i = 0; i < V; i++)
         if (inDegree[i] == 0) q.offer(i);

      while (!q.isEmpty()) {
         int t = q.poll();
         for (int i : adj.get(t)) {
            inDegree[i]--;
            if (inDegree[i] == 0) q.offer(i);
         }
         order.add(t);
      }

      return order.stream().mapToInt(i -> i).toArray();
   }
}
