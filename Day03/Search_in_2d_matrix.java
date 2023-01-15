package Day03;

/*    TC : O(log(rows * cols)), SC : O(1)

According to the question if we linearly arrange the elements of each row, we will have a sorted array.
So we can now perform a binary search over it. The matrix will behave like an array without creating
an auxiliary array by the following formula.

A (n * m) matrix converted into an array: matrix[n][m] : a[(n * m) - 1]
An array can be converted into n * m matrix: a[x] : matrix[x / m][x % m]

(Observed after writing index for every row and column, left-right, top-bottom).
 */
class Search_in_2d_matrix {
   public boolean searchMatrix(int[][] matrix, int target) {
      int rows = matrix.length, cols = matrix[0].length;
      int l = 0, r = (rows * cols) - 1;

      while (l <= r) {
         int mid = l + (r - l) / 2, curr = matrix[mid / cols][mid % cols];
         if (target == curr) return true;
         else if (curr < target) l = mid + 1;
         else r = mid - 1;
      }

      return false;
   }
}