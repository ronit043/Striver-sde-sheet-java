package Day26;

class Subset_sum_equal_to_k {
   static boolean subsetSumToK(int n, int k, int[] arr) {
      boolean[][] dp = new boolean[n][k + 1];

      for (int i = 0; i < n; i++) dp[i][0] = true;
      if (arr[0] <= k) dp[0][arr[0]] = true;

      for (int idx = 1; idx < n; idx++) {
         for (int tgt = 1; tgt <= k; tgt++) {
            boolean pick = dp[idx - 1][tgt], notPick = false;
            if (tgt >= arr[idx]) notPick = dp[idx - 1][tgt - arr[idx]];
            dp[idx][tgt] = pick | notPick;
         }
      }

      return dp[n - 1][k];
   }
}