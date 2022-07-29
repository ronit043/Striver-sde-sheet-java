package Day8;

/*      TC: O(n) n : size of coins array, SC: O(1)

We know if we have an amount X and a certain type of coin, say Y, then we can make a change of int(X / Y)
coins and an amount of X % Y will remain unchanged. So, we use this idea to further optimize our approach
in which we were counting a coin again and again.
 */
public class Minimum_number_of_coins_Greedy {
   public int findMinimumCoins(int amount) {
      int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
      int n = coins.length, coin = 0;

      for (int i = n - 1; i >= 0; i--) {
         while (amount >= coins[i]) {
            coin += amount / coins[i];
            amount %= coins[i];
         }
      }

      return coin;
   }
}