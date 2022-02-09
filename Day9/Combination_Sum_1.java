package Day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_1 {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, target, 0);
        return res;
    }

    public void helper(List<List<Integer>> ans, List<Integer> al, int[] nums, int t, int f) {
        if(t == 0) ans.add(new ArrayList<>(al));
        else if(t < 0) return;
        for (int i = f; i < nums.length; i++) {
            al.add(nums[i]);
            helper(ans, al, nums, t - nums[i], i);
            al.remove(al.size() - 1);
        }
    }
}