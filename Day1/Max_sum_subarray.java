package Day1;

public class Max_sum_subarray {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxi = nums[0];
        for(int i : nums) {
            sum += i;
            maxi = Math.max(sum, maxi);
            if(sum < 0) sum = 0;
        }
        return maxi;
    } 
}