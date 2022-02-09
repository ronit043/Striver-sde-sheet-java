package Day23;

public class Number_of_islands {
    public int numIslands(char[][] grid) {
        int island = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != '0') {
                    island++;
                    dfs(grid, i, j);
                }
            }
        }

        return island;
    }

    public void dfs(char[][] grid, int sr, int sc) {
        if (sr < 0 || sc < 0 ||
                sr >= grid.length || sc >= grid[0].length ||
                grid[sr][sc] != '1') return;

        grid[sr][sc] = '0';

        dfs(grid, sr + 1, sc);
        dfs(grid, sr - 1, sc);
        dfs(grid, sr, sc + 1);
        dfs(grid, sr, sc - 1);
    }
}