package Day3;
import java.util.*;

/*      TC: O(N * logN), SC: O(N)
We use a modified merge sort to solve this problem. Since merge sort works on divide and conquer paradigm,
so, first we divide the array into smaller sorted arrays and merge them to form a completely sorted array.

We can count the number of pairs which satisfies the above conditions while merging the array.
Let mergeSort() be a recursive function which takes the array, starting index ‘l’ on the
start of array and ending index ‘r’, on the end of the array which we are considering.

mergeSort(), after processing the array, we'll return the #pairs which satisfy the above conditions.
In each round we try to divide the array into two parts and sort them.
 */
public class Reverse_Pairs {
   static int merge(int[] nums, int l, int mid, int r) {
      int count = 0, j = mid + 1, left = l, right = mid + 1;
      List<Integer> temp = new ArrayList<>();

      for (int i = l; i <= mid; i++) {
         while (j <= r && nums[i] > (2L * nums[j])) j++;
         count += j - (mid + 1);
      }

      while (left <= mid && right <= r) {
         if (nums[left] <= nums[right]) temp.add(nums[left++]);
         else  temp.add(nums[right++]);
      }
      while (left <= mid)  temp.add(nums[left++]);
      while (right <= r) temp.add(nums[right++]);
      for (int i = l; i <= r; i++) nums[i] = temp.get(i - l);

      return count;
   }

   static int mergeSort(int[] nums, int l, int r) {
      if (l >= r) return 0;
      int mid = (l + r) / 2;
      return mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r) +
              merge(nums, l, mid, r);
   }

   public int reversePairs(int[] nums) { return mergeSort(nums, 0, nums.length - 1); }
}