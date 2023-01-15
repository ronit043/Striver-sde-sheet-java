package Day24;

import java.awt.Point;
import java.util.List;
import java.util.PriorityQueue;

class MST_Prim {
   static int spanningTree(int V, List<List<List<Integer>>> adj) {
      boolean[] vis = new boolean[V];
      return bfs(adj, vis);
   }

   static int bfs(List<List<List<Integer>>> adj, boolean[] vis) {
      int ans = 0;
      // Point class for storing node(x) and weight(y)
      PriorityQueue<Point> pq = new PriorityQueue<>(
              (a, b) -> a.y - b.y
      );
      pq.offer(new Point(0, 0));

      while (!pq.isEmpty()) {
         Point p = pq.poll();
         if (!vis[p.x]) {
            vis[p.x] = true;
            ans += p.y;
            for (var i : adj.get(p.x))
               pq.add(new Point(i.get(0), i.get(1)));
         }
      }

      return ans;
   }
}
