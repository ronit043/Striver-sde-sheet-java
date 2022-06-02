package Day3;

public class Reverse_Pairs {
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1, temp);
    }

    public int mergeSort(int[] nums, int l, int r, int[] temp) {
        int count = 0;
        if (l < r) {
            int m = (l + r) / 2;
            count += mergeSort(nums, l, m, temp) + mergeSort(nums, m + 1, r, temp) +
                    merge(nums, l, m + 1, r, temp);
        }
        return count;
    }

    public int merge(int[] nums, int l, int m, int r, int[] temp) {
        int count = 0, x = m;
        for (int i = l; i < m; i++) {
            while ((x <= r) && (nums[i] > 2 * (long)nums[x])) x++;
            count += x - m;
        }

        int i = l, j = m, k = l;
        while ((i <= m - 1) && (j <= r))
            temp[k++] = (nums[i] <= nums[j]) ? nums[i++] : nums[j++];

        while (i <= m - 1) temp[k++] = nums[i++];
        while (j <= r) temp[k++] = nums[j++];
        for (i = l; i <= r; i++) nums[i] = temp[i];

        return count;
    }
}