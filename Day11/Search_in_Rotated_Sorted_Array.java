package Day11;

/*      TC: O(log(N)), SC: O(1)
It is mentioned that the array given is sorted but in a rotated manner. So, we can divide a given array into
two parts that are sorted. This gives us hints to use binary search. Find the mid-index. If the value(key)
being searched for is at the mid-index, then return the mid-index. If not present, compare values at start,
end and mid-index.

If the left sub-array is monotonically increasing, check if target lies in the range:
    If it does, then safely drop the right part
    Otherwise, safely drop the left part

If the right sub-array is monotonically increasing, check if target lies in the range:
    If it does, then safely drop the left part
    Otherwise, safely drop the right part

Return -1 if never found.
 */
public class Search_in_Rotated_Sorted_Array {
   public int search(int[] nums, int target) {
      int l = 0, r = nums.length - 1;

      while (l <= r) {
         int mid = l + (r - l) / 2;
         if (target == nums[mid]) return mid;

         // left part is monotonically increasing
         if (nums[mid] >= nums[l]) {
            if (target >= nums[l] && target <= nums[mid])
               // drop right part
               r = mid - 1;
            else
               // drop left part
               l = mid + 1;
         }
         // right part is monotonically increasing
         else {
            if (target >= nums[mid] && target <= nums[r])
               // drop left part
               l = mid + 1;
            else
               // drop right part
               r = mid - 1;
         }
      }

      return -1;
   }
}