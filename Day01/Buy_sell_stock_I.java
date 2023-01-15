package Day01;
/*    TC : O(n), SC : O(1)

First our buyPrice would be first element of the array, since we start the transaction from there &
maxProfit, profitToday will be 0.

Starting off, (from 1st index) if we find a price smaller than the buyPrice, update it. After 
updating we calculate today's profit. If it exceeds maxProfit then update.

We do this bcoz, we're allowed only 1 transaction, to find the maxProfit, we need to find the lowest
valley and highest peak, giving the max profit.
*/

class Buy_sell_stock_I {
   public int maxProfit(int[] prices) {
      int buyPrice = prices[0], maxProfit = 0, profitToday;

      for (int i = 1; i < prices.length; i++) {
         buyPrice = Math.min(buyPrice, prices[i]);
         profitToday = prices[i] - buyPrice;
         maxProfit = Math.max(maxProfit, profitToday);
      }

      return maxProfit;
   }
}