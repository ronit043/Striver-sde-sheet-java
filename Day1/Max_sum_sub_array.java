package Day1;

/*
Solution - I (Brute-Force) [TLE]

We can start with brute-force by trying out every possible sub-array in nums and choosing
the one with maximum sum.
    TC : O(n^2)
    SC : O(1)
*/

/*
Solution - II (Kadane's algo)

At every index we have two choices either to include it(in the currMax) or not include it
we choose to not include if we get a lower sum.

And everytime we check and/or update the maxSum

    TC: O(n)
    SC: O(1)
*/

public class Max_sum_sub_array {
    public int maxSubArray(int[] nums) {
        int currMax = nums[0], maxSum = nums[0];

        for (int i : nums) {
            currMax = Math.max(currMax + i, i);
            maxSum = Math.max(maxSum, currMax);
        }

        return maxSum;
    }
}