package Day09;
import java.util.*;

/* TC : O(2 ^ n), SC : O(n)

The idea is to recursively go over to find every possible subset. We sort the res to get items in
increasing order. For every item, we have two choices:

1. Include the item in our subset sum.
2. Don’t include the item in our subset sum.

When we include an item in the set then it will contribute to the subset sum.
 */
class Subset_Sums {
   List<Integer> subsetSums(List<Integer> arr, int N) {
      List<Integer> res = new ArrayList<>();
      dfs(arr, res, 0, 0);
      Collections.sort(res);
      return res;
   }

   void dfs(List<Integer> arr, List<Integer> res, int i, int sum) {
      if (i == arr.size()) { res.add(sum); return; }
      dfs(arr, res, i + 1, sum);
      dfs(arr, res, i + 1, sum + arr.get(i));
   }
}