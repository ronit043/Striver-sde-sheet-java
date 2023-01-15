package Day11;
import java.util.List;

/*      TC: O(rows * log(cols) * log(r - l)), SC: O(1)
For a number to be median, there should be exactly (n / 2) numbers that are less than this number.
So, we try to find the count of a number <= all the numbers.

1. Let l and r be the MIN and MAX items of the matrix respectively. ‘X’(potential median) can be any
number in the range [l, r]. Then we use binary search on [l, r], find the "mid" and get a count of numbers
<= "mid". And accordingly change the l or r.

2. Since each row is sorted in increasing order, we can easily find the total #items in that row
that are <= “mid” using the upper_bound(), if #items >= required count + 1, the median must be
<= the selected number, else the median must be > the selected number.
 */
class Median_of_row_wise_sorted_matrix {
   public int findMedian(List<List<Integer>> matrix) {
      // Since, 1 <= matrix[i][j] <= 10 ^ 9, set the "l" and "r" value accordingly.
      int l = 1, r = (int) 1e9, ans = 0,
          rows = matrix.size(), cols = matrix.get(0).size(), req = (rows * cols) / 2;

      while (l <= r) {
         int mid = l + (r - l) / 2, count = 0;
         for (var row : matrix) count += upper_bound(row, mid);
         if (count >= req + 1) {
            ans = mid;
            r = mid - 1;
         }
         else l = mid + 1;
      }

      return ans;
   }

   public int upper_bound(List<Integer> a, int x) { // closest to the left + 1
      int l = -1, r = a.size();
      while (l + 1 < r) {
         int m = (l + r) >>> 1;
         if (a.get(m) <= x) l = m;
         else r = m;
      }
      return l + 1;
   }
}