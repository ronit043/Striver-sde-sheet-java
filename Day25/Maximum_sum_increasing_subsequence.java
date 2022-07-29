package Day25;

import java.util.Arrays;

public class Maximum_sum_increasing_subsequence {
   public int maxSumIS(int[] arr, int n) {
      int[] dp = new int[n];
      dp[0] = arr[0];

      for (int i = 1; i < n; i++) {
         int max = 0;
         for (int j = 0; j < i; j++) {
            if (arr[i] > arr[j])
               max = Math.max(dp[j], max);
         }
         dp[i] = max + arr[i];
      }

      return Arrays.stream(dp).max().orElseThrow();
   }
}