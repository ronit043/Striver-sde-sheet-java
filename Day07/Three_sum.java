package Day07;
import java.util.*;

/*      TC: O(n ^ 2), SC: O(m)

We are fixing the 'i' index and then applying the traditional 2 pointer approach to check whether the sum of
three numbers equals zero. If the sum < zero, it indicates our sum is probably too less, and we
increment l. Otherwise, if our sum > zero, it indicates our sum is probably too large,
and we need to decrement r index to reduce the sum and bring it closer to zero.
 */
class Three_sum {
   public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> al = new ArrayList<>();
      Arrays.sort(nums);

      for (int i = 0; i < nums.length - 2; i++) {
         if (i > 0 && nums[i] == nums[i - 1]) continue;
         int l = i + 1, r = nums.length - 1;
         while (l < r) {
            int sum = nums[i] + nums[l] + nums[r];
            if (sum < 0) l++;
            else if (sum > 0) r--;
            else {
               al.add(Arrays.asList(nums[i], nums[l], nums[r]));
               while (l < r && nums[l] == nums[l + 1]) l++; l++;
               while (l < r && nums[r] == nums[r - 1]) r--; r--;
            }
         }
      }

      return al;
   }
}