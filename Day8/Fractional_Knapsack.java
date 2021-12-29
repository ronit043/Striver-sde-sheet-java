public class Fractional_Knapsack {
    double fractionalKnapsack(int W, Item[] arr, int n) {
        double ans = 0.00;

        Arrays.sort(arr, (a, b) -> Double.compare(((double) b.value / (double) b.weight),
                ((double) a.value / (double) a.weight)));

        for (int i = 0; i < n && W > 0;) {
            if (arr[i].weight > W) {
                ans += ((double) arr[i].value / (double) arr[i].weight)
                        * (double) W;
                W = 0;
            } else {
                ans += (double) (arr[i].value);
                W -= arr[i].weight;
                i++;
            }
        }
        return ans;
    }
}