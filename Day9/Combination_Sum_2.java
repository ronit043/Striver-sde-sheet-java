package Day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*      TC: O(2^t * k), SC: O(k * x)

Whenever the problem is related to picking up array items to form a combination, start thinking about the
“pick and non-pick” recursive approach. We need to sort the given array/list to avoid duplicates.

    1. If the current item = previous item, then skip this item as it's the duplicate.

Assuming no duplicates,
    1. If you pick the item, add it in the list. In the recursive call, target changes to target – arr[index],
       ans increment index.
    2. While backtracking make sure to remove the last item.

Base cases:
    1. When target becomes 0, add the list to the 2d list.
    2. If target is smaller than 0, return.
 */
public class Combination_Sum_2 {
   public List<List<Integer>> combinationSum2(int[] nums, int target) {
      List<List<Integer>> res = new ArrayList<>();
      Arrays.sort(nums);
      dfs(res, new ArrayList<>(), nums, target, 0);
      return res;
   }

   void dfs(List<List<Integer>> ans, List<Integer> al, int[] nums, int x, int idx) {
      if (x == 0) {
         ans.add(new ArrayList<>(al));
         return;
      }

      for (int i = idx; i < nums.length; i++) {
         if (i > idx && nums[i] == nums[i - 1]) continue;
         al.add(nums[i]);
         dfs(ans, al, nums, x - nums[i], i + 1);
         al.remove(al.size() - 1);
      }
   }
}