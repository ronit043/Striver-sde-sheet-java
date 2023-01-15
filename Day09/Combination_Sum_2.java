package Day09;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*      TC: O(2 ^ k), SC: O(length of longest combination)
We need to sort the given array/list to avoid duplicates easily.
Try choosing all possible ways to select item from the next level(using the loop).
   If the current item = previous item, then skip this item as it's the duplicate.

Otherwise, take the item into consideration reduce sum by the array item & increase the index,
explore with this combination, whether it gives a solution or not.
Irrespective of a valid way being found, after the recursive call we remove the last item to explore new ways.

Base cases:
    1. If target = 0, add the list to the 2d list, because we found a valid sub-sequence with items
     which sum up to 0, and return(backtrack) to explore other ways.
    2. If target is smaller than 0, return(backtrack) as we found an un-needed subsequence.
 */
class Combination_Sum_2 {
   public List<List<Integer>> combinationSum2(int[] nums, int target) {
      List<List<Integer>> res = new ArrayList<>();
      Arrays.sort(nums);
      dfs(res, new ArrayList<>(), nums, target, 0);
      return res;
   }

   void dfs(List<List<Integer>> ans, List<Integer> al, int[] nums, int x, int idx) {
      if (x == 0) { ans.add(new ArrayList<>(al)); return; }
      else if (x < 0) return;

      for (int i = idx; i < nums.length; i++) {
         if (i > idx && nums[i] == nums[i - 1]) continue;
         al.add(nums[i]);
         dfs(ans, al, nums, x - nums[i], i + 1);
         al.remove(al.size() - 1);
      }
   }
}