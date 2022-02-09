package Day1;

public class Buy_sell_stock_ii {
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length == 0) return profit;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) // yesterday was valley, today is peak
                profit += prices[i] - prices[i - 1]; // buy yesterday, sell today
        }
        return profit;
    }
}