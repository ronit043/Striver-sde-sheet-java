package Day26;

import java.util.List;

public class Word_break {
    public int wordBreak(String s, List<String> b) {
        int[] dp = new int[s.length()];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                String word = s.substring(j, i + 1);
                if (b.contains(word)) dp[i] += 1;
            }
        }

        return dp[s.length() - 1] > 0 ? 1 : 0;
    }
}