package Day1;

/*  
    TC : O(n)
    SC : O(1)

Solution

Find the last index(pivot) such that a[i] > a[i - 1]. If no such index exists, the permutation
is the last permutation, so reverse the whole array.

Find the last index(chang) which is just greater than nums[pivot]. After that swap pivot and
chng, and reverse the array from pivot to last index.

Proof

When we want to compute the next permutation, we must “increase” the sequence as little as
possible. Just like when we count up using numbers, we try to modify the rightmost elements
and leave the left side unchanged.

If we don't find a pivot that means the array is decreasing order/ highest permutation and so
reverse.

So there exists an item in the suffix greater than pivot. If we swap pivot with the smallest
element in the suffix that is greater than pivot, then the prefix is minimized.

Finally, we reverse the suffix in non-decreasing order because we increased the prefix,
so we want to make the new suffix as low as possible
*/

public class Next_Permutations {
    public void nextPermutation(int[] nums) {
        int pivot = 0, chng = 0;

        for (int i = nums.length - 1; i > 0; i--)
            if (nums[i] > nums[i - 1]) { pivot = i; break; }

        if (pivot == 0) { reverse(nums, 0, nums.length - 1); return; }

        for (int i = nums.length - 1; i > 0; i--)
            if (nums[i] > nums[pivot - 1]) { chng = i; break; }

        swap(nums, pivot - 1, chng);
        reverse(nums, pivot, nums.length - 1);
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {while(i < j) swap(A, i++, j--);}
}
