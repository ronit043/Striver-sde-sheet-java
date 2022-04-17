package Day1;
/*
Solution - I
    Sort the array, this will make sure groups of 0, 1 and 2 are in the right order
    TC : O(nlog(n))
    SC: O(1)

Solution - II
    Use Dutch national flag algorithm so here's what to do when we encounter a :-
        0, swap i and zero_idx and increase both
        1, just increment i
        2, swap i and two_idx and only increment i because the value swapped with 2 can be anything
           so keeping i in its place can result in placing item at current position in next iterations

    TC : O(n)
    SC : O(1)
*/
public class Sort_012 {
    public void sortColors(int[] nums) {
        int zero_idx = 0, two_idx = nums.length - 1, i = 0;

        for (; i <= two_idx; i++) {
            if (nums[i] == 0) swap(nums, zero_idx++, i++);
            else if (nums[i] == 2) swap(nums, two_idx--, i);
            else i++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}