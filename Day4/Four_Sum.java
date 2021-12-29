import java.util.*;

public class Four_Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> hm = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int n_target = target - nums[i] - nums[j];
                for (int l = j + 1, r = nums.length - 1; l < r;) {
                    int sum = nums[l] + nums[r];
                    if(sum > n_target) r--;
                    else if(sum < n_target) l++;
                    else {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[l]);tmp.add(nums[r]);
                        tmp.add(nums[i]);tmp.add(nums[j]);
                        hm.add(tmp);
                        l++; r--;
                    }
                }
            }
        }

        for (List<Integer> l : hm) res.add(l);
        return res;
    }
}
