package Day10;

import java.util.ArrayList;
import java.util.List;

/*      TC: O(4 ^ (n ^ 2)), SC: O(1)
Start from the initial index (i.e. (0,0)) and look for the valid moves through the adjacent cells in the
order Down -> Left -> Right -> Up (to get the sorted paths) in the grid.

If the move leads to a cell out of bounds / blockage itself then we return, as the path/move can't give a
valid result.

If the bottom right cell is reached then add the directions in the list and return.

Assuming the move is possible, mark the cell as visited(0) then move to that cell in the directions(D,L,R,U)
and again start looking for the valid move until the last index (i.e. (m - 1, n - 1)) is reached. Also set
the cell value as unvisited (i.e. back-tracking) to explore new unvisited nodes.
 */
public class Rat_in_a_maze {
   public List<String> findPath(int[][] maze, int n) {
      List<String> ans = new ArrayList<>();
      if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) return ans;
      dfs(ans, maze, "", n, 0, 0);
      return ans;
   }

   void dfs(List<String> ans, int[][] maze, String path, int n, int x, int y) {
      if (x < 0 || x >= n || y < 0 || y >= n || maze[x][y] == 0)
         return;

      if (x == n - 1 && y == n - 1) {
         ans.add(path);
         return;
      }

      maze[x][y] = 0;
      dfs(ans, maze, path + "D", n, x + 1, y);
      dfs(ans, maze, path + "L", n, x, y - 1);
      dfs(ans, maze, path + "R", n, x, y + 1);
      dfs(ans, maze, path + "U", n, x - 1, y);
      maze[x][y] = 1;
   }
}