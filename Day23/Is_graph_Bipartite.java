package Day23;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Is_graph_Bipartite {
   boolean isBipartite(int[][] graph) {
      int[] color = new int[graph.length];
      Arrays.fill(color, -1);

      for (int i = 0; i < graph.length; i++) {
         if ((color[i] == -1) && !bfs(i, graph, color)) return false;
      }
      return true;
   }

   boolean bfs(int node, int[][] graph, int[] color) {
      Queue<Integer> q = new ArrayDeque<>();
      q.add(node);
      color[node] = 0;

      while (!q.isEmpty()) {
         int curr = q.poll();
         for (int nbr : graph[curr]) {
            if (color[nbr] == -1) {
               // Assign alternate colours to it's neighbours
               color[nbr] = 1 - color[curr];
               q.add(nbr);
            }
            // If neighbor is of same colour return false.
            else if (color[nbr] == color[curr]) return false;
         }
      }

      return true;
   }
}