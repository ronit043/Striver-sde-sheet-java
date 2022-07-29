package Day9;

import java.util.*;

/*
        TC : O(2 ^ N), SC : O(2 ^ N)
Before calling the recursive function sort the array or collection, making duplicates close.
In the recursive function add the empty subset as it's a valid subset.

For each iteration of recursive function:
    1. We will check if the element is duplicate or not. If so we'll ignore.
    2. Then we add the ith element into the subset 'al' and make a recursive call for the next index.
    3. Remove the element after the recursive call to backtrack.
 */
public class Subsets_II {
   public List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      Arrays.sort(nums);
      dfs(res, new ArrayList<>(), nums, 0);
      return res;
   }

   void dfs(List<List<Integer>> res, List<Integer> al, int[] nums, int idx) {
      res.add(new ArrayList<>(al));

      for (int i = idx; i < nums.length; i++) {
         if (i > idx && nums[i] == nums[i - 1]) continue;
         al.add(nums[i]);
         dfs(res, al, nums, i + 1);
         al.remove(al.size() - 1);
      }
   }
}