package Day4;
/*      TC : O(n), SC : O(n)

We maintain a prefix sum for each index. We check if at a particular index the sum is zero.
If it's zero, then we store (index + 1) as the length of the sub-array. Then we hold the sum values in a
hash map. If the sum is present in the hash map, then it means starting from the previous stored index
of sum till the current index, we get another sub-array whose sum is zero. We modify our answer with the
current length else we add the sum along with its index in the map.
 */

import java.util.HashMap;
import java.util.Map;

public class Largest_sub_array_with_0_sum {
   int maxLen(int[] arr, int n) {
      int ans = 0, sum = 0;
      Map<Integer, Integer> hm = new HashMap<>();

      for (int i = 0; i < n; i++) {
         sum += arr[i];
         if (sum == 0) ans = i + 1;
         if (hm.containsKey(sum)) ans = Math.max(i - hm.get(sum), ans);
         else hm.put(sum, i);
      }

      return ans;
   }
}