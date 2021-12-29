public class Next_Permutations {
    public void nextPermutation(int[] nums) {
        int bp = 0, chng = 0;
        for (int i = nums.length - 1; i > 0; i--)
            if (nums[i] > nums[i - 1]) { bp = i; break; }
        if (bp == 0) { reverse(nums, 0, nums.length - 1); return; }
        for (int i = nums.length - 1; i > 0; i--)
            if (nums[i] > nums[bp - 1]) { chng = i; break; }
        swap(nums, bp - 1, chng);
        reverse(nums, bp, nums.length - 1);
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {while(i < j) swap(A, i++, j--);}
}
