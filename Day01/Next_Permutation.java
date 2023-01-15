package Day01;

/*  TC : O(n), SC : O(1)

Find the last index(pivot) such that a[i] > a[i - 1]. If no such index exists, the permutation
is the last permutation, so reverse the whole array.

Find the first index(chng) which is greater than nums[pivot - 1]. After that swap nums[pivot - 1] and
nums[chng], and reverse the array from pivot to last index.

Proof

To compute the next permutation, we must “increase” the sequence as little as possible. Treating the array
as number, we try to modify the rightmost items and leave the left side unchanged.

If pivot is 0 that means the array is in decreasing order/the highest permutation and so reverse.

There exists an item in the suffix greater than (pivot - 1) item. If we swap (pivot - 1)
item with the smallest element in the suffix that is greater than (pivot - 1), then the prefix is maximised.

Finally, we reverse the suffix in non-decreasing order because we increased the prefix,
so we want to make the new suffix as low as possible.
*/

class Next_Permutation {
   public void nextPermutation(int[] nums) {
      int pivot = 0, chng = 0;

      for (int i = nums.length - 1; i > 0; i--)
         if (nums[i] > nums[i - 1]) {
            pivot = i;
            break;
         }

      if (pivot == 0) {
         reverse(nums, 0, nums.length - 1);
         return;
      }

      for (int i = nums.length - 1; i > 0; i--)
         if (nums[i] > nums[pivot - 1]) {
            chng = i;
            break;
         }

      swap(nums, pivot - 1, chng);
      reverse(nums, pivot, nums.length - 1);
   }

   public void swap(int[] A, int i, int j) {
      int tmp = A[i];
      A[i] = A[j];
      A[j] = tmp;
   }

   public void reverse(int[] A, int l, int r) {
      while (l < r) swap(A, l++, r--);
   }
}