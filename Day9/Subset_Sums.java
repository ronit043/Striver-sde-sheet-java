package Day9;

import java.util.*;

/*
    TC : O(2 ^ n), SC : O(n)

The idea is to recursively go over to find every possible subset. We sort the res to get items in
increasing order. For every element, we have two choices:

1. Include the element in our subset sum.
2. Don’t include the element in our subset sum.

When we include an element in the set then it will contribute to the subset sum.
 */
public class Subset_Sums {
   List<Integer> subsetSums(List<Integer> arr, int N) {
      List<Integer> res = new ArrayList<>();
      dfs(arr, res, 0, 0);
      Collections.sort(res);
      return res;
   }

   void dfs(List<Integer> arr, List<Integer> res, int i, int sum) {
      if (i == arr.size()) {
         res.add(sum);
         return;
      }
      dfs(arr, res, i + 1, sum + arr.get(i));
      dfs(arr, res, i + 1, sum);
   }
}