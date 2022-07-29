package Day10;

/*
        TC: O(M ^ V + M * V * V); M: # Colours, V: # Vertices
        SC: O(V)

We generate all possible combinations of colours for coloring the given graph. An optimisation in this method
would be that, we would assign the colours after checking if it is possible to make the vertex of that colour.

We would assign each vertex a colour from 1 to M, check if its adjacent vertex has a different colour or not.

Finally, if we get a configuration such that each node is colored from 1 to M and adjacent vertices are of
different colour, we return true. Otherwise, we return false.
 */
public class M_Coloring {
   public boolean graphColoring(boolean[][] graph, int m, int n) {
      return colouringPossible(graph, new int[n], m, n, 0);
   }

   boolean colouringPossible(boolean[][] graph, int[] visited, int m, int n, int node) {
      if (node == n) return true;

      for (int i = 1; i <= m; i++) {
         if (isValid(graph, visited, node, n, i)) {
            visited[node] = i;
            if (colouringPossible(graph, visited, m, n, node + 1)) return true;
            visited[node] = 0;
         }
      }

      return false;
   }

   boolean isValid(boolean[][] graph, int[] visited, int node, int n, int col) {
      for (int i = 0; i < n; i++)
         if (graph[i][node] && visited[i] == col) return false;
      return true;
   }
}