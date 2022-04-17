package Day9;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, 0);

        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> ls, int[] nums, int pos) {
        res.add(new ArrayList<>(ls));

        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) continue;
            ls.add(nums[i]);
            helper(res, ls, nums, i + 1);
            ls.remove(ls.size() - 1);
        }
    }
}