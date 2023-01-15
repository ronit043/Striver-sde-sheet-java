package Day25;
/*    TC: O(n), SC: O(1)
The following approach is motivated by Kadane’s algorithm. The pick point for this problem is that we can get
the maximum product from the product of two -ve numbers too. Initially store 0th index value in maxP, minP
and ans.

Traverse the array from index 1. If the current item is -ve, then we swap maxP and minP so that maxP always
stores the max product after multiplying the -ve value.
Otherwise,
maxP will store the maximum of two choices either to include the value as product into running sub-array
or create a new sub-array of value as the current item. We'll do the same for minP as well but this time
taking minimum of two choices. Update the ans to store the maximum of ans and maxP.
 */
class Maximum_Product_sub_array {
   public int maxProduct(int[] nums) {
      int maxP = nums[0], minP = nums[0], ans = nums[0];

      for (int i = 1; i < nums.length; i++) {
         if (nums[i] < 0) { int temp = maxP; maxP = minP; minP = temp; }
         maxP = Math.max(nums[i], maxP * nums[i]);
         minP = Math.min(nums[i], minP * nums[i]);
         ans = Math.max(ans, maxP);
      }

      return ans;
   }
}