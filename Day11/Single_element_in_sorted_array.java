package Day11;

/*      TC: O(log(n)), SC: O(1)
So the algorithmic approach will be to use binary search. The intuition is that when we see an item,
we know its index and depending on whether it is the first or the second occurrence, we can decide
if we are present in the left or right sub-array. Moreover, we can decide which direction we need to move
to find the breakpoint between our left and right sub-array.

We need to make sure whether we're in the left or right half, For being in the left half:
1. First occurrence is even
2. Second occurrence is odd

We take idx as mid ^ 1; adds 1 to mid if its even, else reduces 1. If mid is even we'll get the next odd
index otherwise if mid is odd we'll get previous even index. If the items at two indices match then we're
in the left half otherwise in the right half.

Finally, l will be on next of right half so return item at l
 */
class Single_element_in_sorted_array {
   public int singleNonDuplicate(int[] nums) {
      int l = 0, r = nums.length - 2;

      while (l <= r) {
         int mid = l + (r - l) / 2;
         if (nums[mid] == nums[mid ^ 1])
            l = mid + 1;
         else
            r = mid - 1;
      }

      return nums[l];
   }
}