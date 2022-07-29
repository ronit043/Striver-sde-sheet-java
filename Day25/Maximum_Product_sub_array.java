package Day25;

import java.util.stream.IntStream;

public class Maximum_Product_sub_array {
   public int maxProduct(int[] nums) {
      int ans = nums[0], large = nums[0], small = nums[0];

      if (nums.length == 1) return large;
      for (int i = 1; i < nums.length; i++) {
         int temp = IntStream.of(nums[i], large * nums[i], small * nums[i]).max().getAsInt();
         small = IntStream.of(nums[i], large * nums[i], small * nums[i]).min().getAsInt();
         large = temp;
         ans = Math.max(ans, large);
      }

      return ans;
   }
}