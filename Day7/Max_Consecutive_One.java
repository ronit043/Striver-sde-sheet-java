package Day7;

public class Max_Consecutive_One {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0, max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                cnt++;
                max = Math.max(cnt, max);
            }
            else cnt = 0;
        }
        return max;
    }
}