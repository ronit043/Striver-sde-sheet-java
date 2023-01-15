package Day11;

/*      TC: O(log(min(m, n))), SC: O(1)
If length of first array < length of second then swap both the arrays. We can part it in such a way that our
kth item will be at the end of the left half array. The left portion of the array is made of some items
of both array1 and array2. We can see that all items of the right half of the array are always > left ones.
So, using binary search, we will divide arrays into partitions with keeping k items in the left half.

Start iterating with two indexes, say left and right. Find the middle of the range. Take items from low to
middle of array1 and the remaining items from the second array. Then using the condition mentioned above,
check if the left half is valid. If valid, print the maximum of both array’s last item. If not, move the
range towards the right if l2 > r1, else move the range towards the left if l1 > r2.
 */
class Kth_element_of_2_sorted_arrays {
   public long kthElement(int[] a, int[] b, int n, int m, int k) {
      if (n > m) return kthElement(b, a, m, n, k);
      int l = Math.max(0, k - m), r = Math.min(n, k);

      while (l <= r) {
         int cut1 = l + (r - l) / 2, cut2 = k - cut1;

         int l1 = (cut1 == 0) ? Integer.MIN_VALUE : a[cut1 - 1],
             l2 = (cut2 == 0) ? Integer.MIN_VALUE : b[cut2 - 1],
             r1 = (cut1 == n) ? Integer.MAX_VALUE : a[cut1],
             r2 = (cut2 == m) ? Integer.MAX_VALUE : b[cut2];

         if (l1 <= r2 && l2 <= r1) return Math.max(l1, l2);
         else if (l1 > r2) r = cut1 - 1;
         else l = cut1 + 1;
      }

      return -1;
   }
}