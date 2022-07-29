package Day4;

/*
    TC : O(n), SC : O(n)

There is ALWAYS only 1 pair of numbers that satisfy the condition of adding together to be the target value.
We can assume that for all the numbers, there exists a pair such that xa + xb = target.
To solve this with a single pass of the list we can change the equation above to xa = target - xb
*/

import java.util.Map;
import java.util.HashMap;

public class Two_Sum {
   public int[] twoSum(int[] nums, int target) {
      int[] result = new int[2];
      Map<Integer, Integer> hm = new HashMap<>();

      for (int i = 0; i < nums.length; i++) {
         if (hm.containsKey(target - nums[i])) {
            result[0] = hm.get(target - nums[i]);
            result[1] = i;
         }
         if (!hm.containsKey(nums[i])) hm.put(nums[i], i);
      }

      return result;
   }
}