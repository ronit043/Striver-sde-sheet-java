package Day23;
import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Queue;

class Detect_cycle_UG_BFS {
   public boolean canFinish(int numCourses, int[][] prerequisites) {
      boolean[] vis = new boolean[numCourses + 1];

      for (int i = 0; i < numCourses; i++)
         if (!vis[i] && bfs(i, vis, prerequisites)) return true;

      return false;
   }

   boolean bfs(int i, boolean[] vis, int[][] graph) {
      Queue<Point> q = new ArrayDeque<>();
      q.add(new Point(i, -1));
      vis[i] = true;

      while (!q.isEmpty()) {
         Point p = q.poll();
         int curr = p.x, parent = p.y;

         for (int nbr : graph[curr]) {
            if (!vis[curr]) {
               vis[curr] = true;
               q.add(new Point(nbr, curr));
            }
            // Checking for a cycle
            else if (nbr != parent) return true;
         }
      }

      return false;
   }
}