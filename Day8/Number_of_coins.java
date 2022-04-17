package Day8;

import java.util.Arrays;

public class Number_of_coins {
    static int minCoins(int[] coins, int m, int V) {
        int[] dp = new int[V + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int value = 1; value <= V; value++) {
            for (int coin : coins) {
                if (coin <= value) {
                    int sub_res = dp[value - coin];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < dp[value])
                        dp[value] = sub_res + 1;
                }
            }
        }

        return (dp[V] == Integer.MAX_VALUE) ? -1 : dp[V];

    }
}