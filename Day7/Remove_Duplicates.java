package Day7;

/*
We know that the array is sorted, and hence all the occurrences of a number will be clustered together.

Keeping this in mind ‘nums[fast]’ != ‘nums[fast - 1]’ -> the duplicate ends and now,
we must copy the value of ‘nums[fast]’ to ‘nums[slow++]’.

We repeat the same process until fast reaches the end of the array. Return ‘slow’ at the end.
 */
public class Remove_Duplicates {
   public int removeDuplicates(int[] nums) {
      int slow = 0;

      for (int fast = 1; fast < nums.length; fast++) {
         if (nums[fast] != nums[fast - 1])
            nums[slow++] = nums[fast];
      }

      return slow + 1;
   }
}