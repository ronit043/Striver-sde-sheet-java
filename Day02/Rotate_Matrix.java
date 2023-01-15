package Day02;

/*    TC : O(n ^ 2), SC : O(1)

We have to rotate the matrix 90 degrees clockwise. First transpose the matrix, converting the rows to columns
After that for every row in the transposed matrix we reverse it.
 */
class Rotate_Matrix {
   public void rotate(int[][] matrix) {
      int rows = matrix.length;

      // Transpose Logic
      for (int r = 0; r < rows; r++) {
         for (int c = 0; c < r; c++)
            swap(matrix, r, c, c, r);
      }
      // Reverse logic
      for (int i = 0; i < rows; i++) {
         for (int l = 0, r = rows - 1; l <= r; l++, r--)
            swap(matrix, i, l, i, r);
      }
   }

   public void swap(int[][] m, int i, int j, int s, int t) {
      int temp = m[i][j];
      m[i][j] = m[s][t];
      m[s][t] = temp;
   }
}