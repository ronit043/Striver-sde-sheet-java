package Day25;
import java.util.stream.IntStream;

class Edit_Distance {
   public int minDistance(String word1, String word2) {
      int m = word1.length(), n = word2.length();
      int[][] dp = new int[m + 1][n + 1];

      // If any string is exhausted, then the remaining characters in the other string
      // will be the number of characters to convert current string to other string
      for (int j = 0; j <= n; j++) dp[0][j] = j;
      for (int i = 0; i <= m; i++) dp[i][0] = i;

      for (int i = 1; i <= m; i++) {
         for (int j = 1; j <= n; j++) {
            if (word1.charAt(i - 1) == word2.charAt(j - 1))
               dp[i][j] = dp[i - 1][j - 1];
            else {
               int replace = dp[i - 1][j - 1], delete = dp[i - 1][j], insert = dp[i][j - 1];
               dp[i][j] = 1 + IntStream.of(replace, delete, insert).min().orElseThrow();
            }
         }
      }

      return dp[m][n];
   }
}
