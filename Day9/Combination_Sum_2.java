package Day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public void helper(List<List<Integer>> ans, List<Integer> al, int[] nums, int t, int f) {
        if(t == 0) ans.add(new ArrayList<>(al));
        else if(t < 0) return;
        for (int i = f; i < nums.length; i++) {
            if(i > f && nums[i] == nums[i - 1]) continue; // skipping duplicates
            al.add(nums[i]);
            helper(ans, al, nums, t - nums[i], i + 1);
            al.remove(al.size() - 1);
        }
    }
}