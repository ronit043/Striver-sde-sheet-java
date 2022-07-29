package Day1;

/*
    TC: O(n), SC: O(1)

At every index we have two choices either to include the item (in the currMax) or not include it
we don't include if we get a lower sum. We have to also include the adjacent items, to make the sub-array
contiguous. And everytime we check and/or update the maxSum.
*/

public class Max_sum_sub_array {
   public int maxSubArray(int[] nums) {
      int currMax = 0, maxSum = Integer.MAX_VALUE;

      for (int i : nums) {
         currMax = Math.max(currMax + i, i);
         maxSum = Math.max(maxSum, currMax);
      }

      return maxSum;
   }
}