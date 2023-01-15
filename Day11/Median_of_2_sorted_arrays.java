package Day11;
/*    TC: O(log(m, n)), SC: O(1)
We will do a binary search in one of the arrays which have a minimum size among the two. 

We know that we will get answers only from the final merged sorted arrays. We will partition both the arrays
in such a way that the left half of the partition will contain items, which will be there when we merge them,
till the median element and rest in the other right half. This partitioning will be done by binary search.

Firstly, calculate the median position with (m+n+1)/2. Place two-index, say l and r, equal to 0 and size
of the array on which we're applying binary search. Find the partition of the array. Check if the left half
has a total #items = the median position. If not, get the remaining items from the second array.
Now, check if partitioning is valid. This is only when l1 <= r2 and l2 <= r1. If valid, return max(l1, l2)
(when odd #items present) else return (max(l1, l2) + min(r1, r2)) / 2.

If partitioning is invalid, move ranges. When l1 > r2, move left and perform the above operations again.
When l2 > r2, move right and perform the above operations.
 */
class Median_of_2_sorted_arrays {
   double findMedianSortedArrays(int[] A, int[] B) {
      int A_size = A.length, B_size = B.length;
      if (A_size > B_size) return findMedianSortedArrays(B, A); // Swapping to make A smaller
      int l = 0, r = A_size, median_pos = (A_size + B_size + 1) / 2;

      while (l <= r) {
         int cutA = (l + r) / 2, cutB = median_pos - cutA;

         int leftA = (cutA == 0) ? Integer.MIN_VALUE : A[cutA - 1],
             leftB = (cutB == 0) ? Integer.MIN_VALUE : B[cutB - 1],
             rightA = (cutA == B_size) ? Integer.MAX_VALUE : A[cutA],
             rightB = (cutB == A_size) ? Integer.MAX_VALUE : B[cutB];

         // if correct partition is done
         if (leftA <= rightB && leftB <= rightA) {
            if ((B_size + A_size) % 2 == 0)
               return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
            return Math.max(leftA, leftB);
         } else if (leftA > rightB) r = cutA - 1;
         else l = cutA + 1;
      }

      return -1;
   }
}