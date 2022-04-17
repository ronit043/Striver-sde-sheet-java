package Day11;

public class Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) return m;

            // left half is sorted
            if (nums[m] >= nums[l]) {
                if (nums[l] <= target && nums[m] >= target)
                    r = m - 1;
                else
                    l = m + 1;
            }
            // right half is sorted
            else {
                if (nums[m] <= target && nums[r] >= target)
                    l = m + 1;
                else
                    r = m - 1;
            }
        }

        return -1;
    }
}