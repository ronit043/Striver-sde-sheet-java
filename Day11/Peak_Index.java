package Day11;

/*      TC: O(log(n)), SC: O(1)
The idea is based on the technique of Binary Search to check if the middle element is the peak item or not.
In each iteration, we check the mid:

If nums[mid] is < nums[mid + 1], then we're in ascending part of array, so move right to find an item >
current item.

Else we're in decreasing part of array. This maybe the ans, but look at left.

At last l will be at the peak index so return l.
 */
public class Peak_Index {
   public int peakIndexInMountainArray(int[] nums) {
      int l = 0, r = nums.length - 1 ;

      while (l <= r) {
         int mid = l + (r - l) / 2;
         if (check(nums, mid)) l = mid + 1;
         else r = mid - 1;
      }

      return l;
   }
   boolean check(int[] nums, int m) { return nums[m] < nums[m + 1]; }
}