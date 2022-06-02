package Day3;

/*
    TC : O(rows * cols), SC : O(rows * cols)

We'll use dynamic programming here using a dp matrix dp[r][c] will denote the number of unique paths from cell(0, 0)
to (r, c). Base cases

We start at cell (0, 0), so dp[0][0] = 1.

Since we can only move right or down, there is only one way to reach a cell (r, 0) or (0, c).
Thus, we also initialize dp[r][0] = 1 and dp[0][c] = 1.

For every other cell (r, c)  we can reach here either from the top cell (r - 1, c) or the left cell (r, c - 1).
So the result of unique paths to arrive at (r, c) is the  summation of both, i.e,
dp[r][c] = dp[r - 1][c] + dp[r][c - 1].
 */
public class Grid_Unique_Paths {
    public int uniquePaths(int rows, int cols) {
        int[][] dp = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0 || c == 0) dp[r][c] = 1;
                else dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }

        return dp[rows - 1][cols - 1];
    }
}