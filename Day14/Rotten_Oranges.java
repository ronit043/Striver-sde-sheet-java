package Day14;

import java.util.ArrayDeque;
import java.util.Queue;

public class Rotten_Oranges {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, count_fresh = 0, count = 0;
        int[][] dirs = {{1, 0}, { -1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < cols ; j++) {
                if (grid[i][j] == 2) q.add(new int[] {i , j});
                else if (grid[i][j] == 1) count_fresh++;
            }
        }

        if (count_fresh == 0) return 0;

        while (!q.isEmpty()) {
            ++count;
            int size = q.size();
            for (int i = 0 ; i < size ; i++) {
                int[] point = q.poll();
                for (var dir : dirs) {
                    int x = point[0] + dir[0], y = point[1] + dir[1];
                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    grid[x][y] = 2;
                    q.add(new int[] {x , y});
                    count_fresh--;
                }
            }
        }

        return count_fresh == 0 ? count - 1 : -1;
    }
}