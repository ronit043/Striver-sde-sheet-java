package Day1;

/*
    TC : O(n)
    SC : O(1)
*/

/*
Solution

First our buyPrice would be first element of the array, since we start the transcation
from there & maxProfit, profitToday will be set to 0.

Starting the traversal if we find a price smaller than the buyPrice, update buyPrice,
after updating we calculate today's profit. If today's profit exceeds maximum profit
then update.

We do this bcoz, we're allowed only 1 transaction, to find the maximum profit,
we need to find the lowest valley and topmost peak, giving the max profit
*/

public class Buy_sell_stock_I {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0], maxProfit = 0, profitToday = 0;

        for (int i = 1; i < prices.length; i++) {
            buyPrice = Math.min(buyPrice, prices[i]);
            profitToday = prices[i] - buyPrice;
            maxProfit = Math.max(maxProfit, profitToday);
        }

        return maxProfit;
    }
}