package Day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_1 {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(res, new ArrayList<>(), nums, target, 0);

        return res;
    }

    void dfs(List<List<Integer>> ans, List<Integer> al, int[] nums, int x, int i) {
        if(x == 0) ans.add(new ArrayList<>(al));

        else if(x < 0) return;

        for (int idx = i; idx < nums.length; idx++) {
            al.add(nums[idx]);
            dfs(ans, al, nums, x - nums[idx], idx);
            al.remove(al.size() - 1);
        }
    }
}