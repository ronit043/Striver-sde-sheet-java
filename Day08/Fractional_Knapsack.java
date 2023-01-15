package Day08;

import java.util.Arrays;

/*      TC : O(N * log(N)), SC: O(1)

First sort on the ratio of value by weight in decreasing order. Now go through every item and check if it's
weight exceeds the given capacity or not.

If yes, then we break the item into smaller units of value = value of item / weight of item * weight capacity
add the value to the answer and set weight capacity = 0;

Otherwise, add the value of item to the answer and decrease the weight capacity by the item weight.
 */
public class Fractional_Knapsack {
   double fractionalKnapsack(int W, Item[] arr, int n) {
      double ans = 0.00;

      Arrays.sort(arr, (a, b) -> Double.compare(
              ((double) b.value / (double) b.weight),
              ((double) a.value / (double) a.weight)
      ));

      for (int i = 0; i < n && W > 0; ) {
         if (arr[i].weight > W) {
            ans += ((double) arr[i].value /
                    (double) arr[i].weight) * (double) W;
            W = 0;
         } else {
            ans += arr[i].value;
            W -= arr[i].weight;
            i++;
         }
      }
      return ans;
   }
}

class Item {
   int value, weight;

   Item(int _value, int _weight) {
      value = _value;
      weight = _weight;
   }
}