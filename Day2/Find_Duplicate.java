package Day2;
/*
    TC: O(n), SC : O(1)

    Solution

Using Floyd's cycle detection algorithm, we take two references slow and fast initially assigned to first
item of the array. We move slow ref. by one step and fast ref. by 2 steps until they both meet at a point.

After meeting assign any ref. to index 0 item, and start moving both references by one step. The point of
intersection is the duplicate item.
 */
public class Find_Duplicate {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        slow = nums[0];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}