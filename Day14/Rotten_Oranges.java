package Day14;
import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Deque;

/*    TC: O(N * M), where N and M are the numbers of rows and columns of the grid respectively.
      SC : O(N * M)
The idea is that for each rotten orange, we will find how many fresh oranges there are in its 4 directions.
If we find any fresh orange we will make it into a rotten orange. One rotten orange can rotten up to 4 fresh
oranges present in its 4 directions. For this problem, we will be using the BFS technique. Use a Queue data
structure to store coordinate of Rotten Oranges.

We traverse the whole grid and count the total number of oranges in the grid and store it in total_orange.
Then we will also push the rotten oranges in the Queue as well.

Now while our queue is not empty, we will pick up each Rotten Orange and check in all its 4 directions
whether a Fresh orange is present or not. If it is present we will make it rotten and push it in our queue
and pop out the rotten orange which we took up as its work is done now.

If the queue is empty that case, we will increase our total time.
After it becomes empty, We will check whether the total number of oranges initially is equal to the current
count of oranges. If yes, we will return the total time taken, else will return -1 because some fresh oranges
are still left and can’t be made rotten.
 */
public class Rotten_Oranges {
   public int orangesRotting(int[][] grid) {
      int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
      int rows = grid.length, cols = grid[0].length;
      Deque<Point> rotten = new ArrayDeque<>();
      int minutes = 0, total_orange = 0, rotten_oranges = 0;

      for (int i = 0; i < rows; ++i) {
         for (int j = 0; j < cols; ++j) {
            if (grid[i][j] != 0) total_orange++;
            if (grid[i][j] == 2) rotten.add(new Point(i, j));
         }
      }

      while (!rotten.isEmpty()) {
         int k = rotten.size();
         rotten_oranges += k;
         while (k-- > 0) {
            int x = rotten.getFirst().x, y = rotten.getFirst().y;
            rotten.remove();
            for (int i = 0; i < 4; ++i) {
               int nx = x + dx[i], ny = y + dy[i];
               if (nx < 0 || ny < 0 || nx >= rows || ny >= cols || grid[nx][ny] != 1) continue;
               grid[nx][ny] = 2;
               rotten.add(new Point(nx, ny));
            }
         }
         if (!rotten.isEmpty()) minutes++;
      }

      return total_orange == rotten_oranges ? minutes : -1;
   }
}