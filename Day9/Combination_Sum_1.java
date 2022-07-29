package Day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*      TC: O(2 ^ t * k), SC: O(k * x)

Whenever the problem is related to picking up array items to form a combination, start thinking about the
“pick and non-pick” recursive approach.

    1. If you pick the item, add it in the list. In the recursive call, x changes to x – arr[index]. Don't
    change the index as multiple occurrences of the same element is possible.
    2. While backtracking make sure to remove the last item.

Keep on repeating this process till index < size of the array for a particular recursion call.

Base cases:
    1. When target becomes 0, add the list to the 2d list.
    2. If target is smaller than 0, return.
 */
public class Combination_Sum_1 {
   public List<List<Integer>> combinationSum(int[] nums, int target) {
      List<List<Integer>> res = new ArrayList<>();
      dfs(res, new ArrayList<>(), nums, target, 0);
      return res;
   }

   void dfs(List<List<Integer>> ans, List<Integer> al, int[] nums, int x, int idx) {
      if (x == 0) {
         ans.add(new ArrayList<>(al));
         return;
      }

      for (int i = idx; i < nums.length; i++) {
         al.add(nums[i]);
         dfs(ans, al, nums, x - nums[i], i);
         al.remove(al.size() - 1);
      }
   }
}