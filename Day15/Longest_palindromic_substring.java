package Day15;

public class Longest_palindromic_substring {
   public static String longestPalindrome(String s) {
      int n = s.length(), start = 0, maxLen = 0;
      boolean[][] dp = new boolean[n][n];
      // dp[i][j] indicates whether sub-string s starting at index i and ending at j is palindrome

      for (int i = n - 1; i >= 0; i--) { // keep decreasing the possible palindrome string
         for (int j = i; j < n; j++) { // find the max palindrome within this window of (i,j)

            // Check if sub-string between (i, j) is palindrome
            dp[i][j] = (s.charAt(i) == s.charAt(j)) && // chars at i and j should match
            (j - i < 3 || // if window is less than or equal to 3, just end chars should match
            dp[i + 1][j - 1]); // if window is > 3, sub-string (i + 1, j - 1) should be palindrome too

            // Update max palindrome string
            if (dp[i][j] && j - i + 1 > maxLen) {
               start = i;
               maxLen = j - i + 1;
            }
         }
      }

      return s.substring(start, start + maxLen);
   }
}
