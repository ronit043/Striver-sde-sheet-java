package Day24;

import java.awt.Point;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra_Algorithm {
   static int[] dijkstra(int V, List<List<List<Integer>>> adj, int S) {
      boolean[] vis = new boolean[V];
      int[] res = new int[V];
      bfs(adj, vis, res, S);
      return res;
   }

   static void bfs(List<List<List<Integer>>> adj, boolean[] vis, int[] res, int S) {
      // Point class for storing the current node(x) and weight(y)
      PriorityQueue<Point> pq = new PriorityQueue<>(
              (a, b) -> a.y - b.y
      );
      pq.add(new Point(S, 0));

      while (!pq.isEmpty()) {
         Point temp = pq.poll();
         if (vis[temp.x]) continue;
         vis[temp.x] = true;

         for (var edge : adj.get(temp.x)) {
            Point p = new Point(edge.get(0), edge.get(1) + temp.y);
            if (vis[p.x]) continue;
            pq.add(p);
         }

         res[temp.x] = temp.y;
      }
   }
}