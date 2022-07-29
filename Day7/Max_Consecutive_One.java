package Day7;

/*      TC : O(n), SC: O(1)

We move through the array and count the number of 1’s found. Each time we see a 0, we will reset count to 0.
We can keep track of the maximum value for count through the entire iteration, and that will be the answer.
 */
public class Max_Consecutive_One {
   public int findMaxConsecutiveOnes(int[] nums) {
      int oneCount = 0, ans = 0;

      for (int num : nums) {
         if (num == 1) {
            oneCount++;
            ans = Math.max(oneCount, ans);
         } else oneCount = 0;
      }

      return ans;
   }
}