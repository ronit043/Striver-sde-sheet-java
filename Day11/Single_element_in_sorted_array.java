package Day11;

public class Single_element_in_sorted_array {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        int ans = 0;

        for(int i = nums.length - 1; i >= 0; i--) {
            if(i - 1 > 0 && nums[i] == nums[i - 1]) i--;
            else {
                ans = nums[i];
                break;
            }
        }

        return ans;
    }
}