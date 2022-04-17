package Day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> al = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int l = i + 1, r = nums.length - 1, a = -nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == a) {
                        al.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    }
                    else if (nums[l] + nums[r] > a) r--;
                    else l++;
                }
            }
        }

        return al;
    }
}