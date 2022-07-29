package Day26;

public class Rod_cutting {
   public int cutRod(int[] prices, int rodLen) {
      int[][] dp = new int[rodLen][rodLen + 1];

      for (int len = 0; len <= rodLen; len++)
         dp[0][len] = len * prices[0];

      for (int idx = 1; idx < rodLen; idx++) {
         for (int len = 0; len <= rodLen; len++) {
            int notCut = dp[idx - 1][len], cut = Integer.MIN_VALUE;
            if (len >= idx + 1) cut = prices[idx] + dp[idx][len - idx - 1];
            dp[idx][len] = Math.max(notCut, cut);
         }
      }

      return dp[rodLen - 1][rodLen];
   }
}