package Day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*          TC: O(N * N!) , SC : O(1)
Using backtracking to solve this. We have the nums array, so we will declare an ans list of list
that will store all the permutations. Call a recursive function(dfs) with ans, nums, 0 as arguments

Base case: Whenever the index reaches the end take the nums array and put it in ans list and return.

Go from index to n – 1 and swap. Once the swap has been done call recursion for the next state. After coming
back from the recursion make sure you re-swap it because for the next element the swap will not take place.
 */
public class Permutations_Array {
   public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      dfs(res, nums, 0);
      return res;
   }

   void dfs(List<List<Integer>> res, int[] nums, int i) {
      if (i == nums.length) {
         List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
         res.add(list);
         return;
      }
      for (int idx = i; idx < nums.length; idx++) {
         swap(nums, i, idx);
         dfs(res, nums, i + 1);
         swap(nums, i, idx);
      }
   }

   public void swap(int[] nums, int idx, int j) {
      int temp = nums[idx];
      nums[idx] = nums[j];
      nums[j] = temp;
   }
}