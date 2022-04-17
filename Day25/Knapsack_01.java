package Day25;

public class Knapsack_01 {
    public int solve(int[] val, int[] wght, int W) {
        int n = val.length;
        int[][] dp = new int[n][W + 1];

        for (int wt = 0; wt <= W; wt++)
            dp[0][wt] = (wght[0] <= wt) ? val[0] : 0;

        for (int idx = 1; idx < n; idx++) {
            for (int wt = 0; wt <= W; wt++) {
                int notPick = dp[idx - 1][wt], pick = Integer.MIN_VALUE;
                if (wght[idx] <= wt) pick = val[idx] + dp[idx - 1][wt - wght[idx]];
                dp[idx][wt] = Math.max(pick, notPick);
            }
        }

        return dp[n - 1][W];
    }
}