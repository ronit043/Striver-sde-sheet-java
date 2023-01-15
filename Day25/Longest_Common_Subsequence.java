package Day25;
class Longest_Common_Subsequence {
   public int longestCommonSubsequence(String text1, String text2) {
      int n = text1.length(), m = text2.length();
      int[][] dp = new int[n + 1][m + 1];
      // If two characters match, length of the common subsequence would be 1 plus the length
      // of the common subsequence till the i - 1 and j - 1 indexes
      // If two characters doesn't match, we will take the longer by either skipping i or j indexes
      for (int i = 1; i <= n; i++) {
         for (int j = 1; j <= m; j++) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
            else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
         }
      }

      return dp[n][m];
   }
}