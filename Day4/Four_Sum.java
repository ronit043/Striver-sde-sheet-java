package Day4;
/*
    TC: O(n ^ 3), SC : O(n)

    Sort the array, and then fix two nested pointers. Now we fix two pointers l and r, then use these
    to calculate the sum. If sum equals target add the 4 items to the list. If sum is smaller, then
    move l else move r. Move over the duplicate items as well.
 */

import java.util.*;

public class Four_Sum {
   public List<List<Integer>> fourSum(int[] nums, int target) {
      List<List<Integer>> al = new ArrayList<>();
      Arrays.sort(nums);

      for (int i = 0; i < nums.length - 3; i++) {
         if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates
         for (int j = i + 1; j < nums.length - 2; j++) {
            if (j > i + 1 && nums[j] == nums[j - 1]) continue; // skip duplicates

            long sum = (long) target - nums[i] - nums[j];
            int l = j + 1, r = nums.length - 1;
            while (l < r) {
               if (nums[l] + nums[r] > sum) r--;
               else if (nums[l] + nums[r] < sum) l++;
               else {
                  al.add(Arrays.asList(nums[i], nums[j], nums[l++], nums[r--]));
                  while (l < r && nums[l] == nums[l - 1]) l++; // skip duplicates
                  while (l < r && nums[r] == nums[r + 1]) r--; // skip duplicates
               }
            }
         }
      }

      return al;
   }
}
