package Day7;

public class Remove_Duplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int count = 1;

        for(int slow = 0, fast = 0; fast < nums.length; ) {
            if(nums[slow] != nums[fast]) { 
                count++;
                nums[slow + 1] = nums[fast];
                slow++;
            }
            fast++;
        }

        return count;
    }
}