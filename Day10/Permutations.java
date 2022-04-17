package Day10;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        help(res, nums, 0);

        return res;
    }

    public void help(List<List<Integer>> res, int[] nums, int s) {
        if (s == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) list.add(n);
            res.add(list);
            return;
        }
        for (int i = s; i < nums.length; i++) {
            swap(nums, s, i);
            help(res, nums, s + 1);
            swap(nums, s, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }   
}