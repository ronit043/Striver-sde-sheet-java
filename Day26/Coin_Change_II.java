package Day26;

class Coin_Change_II {
   public int change(int value, int[] coins) {
      int[][] dp = new int[coins.length][value + 1];

      for (int i = 0; i <= value; i++) dp[0][i] = (i % coins[0] == 0) ? 1 : 0;

      for (int c = 1; c < coins.length; ++c) {
         for (int v = 0; v <= value; ++v) {
            int notTake = dp[c - 1][v], take = 0;
            if (coins[c] <= v) take = dp[c][v - coins[c]];
            dp[c][v] = take + notTake;
         }
      }

      return dp[coins.length - 1][value];
   }
}