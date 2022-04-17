package Day26;

/*
    TC : O(n ^ 2)
    SC : O(n ^ 2)

    dp matrix holds the palindrome information, dp[i][j] represents whether s[i] to s[j] can form a palindrome
    res[i] represents the minimum cut needed from s[0] to s[i]. If s[i] to s[j] is a palindrome try to
    update the cut with res[i - 1]
 */

public class Palindromic_Partioning {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = buildMatrix(s, n);
        int[] res = new int[n];

        for (int j = 0; j < n; j++) {
            int cut = j;
            for (int i = 0; i <= j; i++) {
                if (dp[i][j])
                    cut = Math.min(cut, i == 0 ? 0 : res[i - 1] + 1);
            }
            res[j] = cut;
        }
        return res[n - 1];
    }

    boolean[][] buildMatrix(String s, int n) {
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) &&
                        j - i <= 2 || dp[i + 1][j - 1]);
            }
        }

        return dp;
    }
}