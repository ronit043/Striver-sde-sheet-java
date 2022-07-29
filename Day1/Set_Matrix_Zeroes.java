package Day1;

/*
    TC : O(2 * (m * n)), SC : O(1)

We first traverse from top to bottom and check
    If the first column of any row is 0 or not, if so set the colChange value to true.
    We then move from index 1 of every row and check if any element is 0, if so set the topmost and leftmost
    value to 0, we do this to keep a track of which items to change on coming back later.

In the 2nd traversal, moving backwards
    If the leftmost or topmost value is 0 then set that item to 0.
    Before moving to the next row, change the first column value to 0, if colChange is true

    We use colChange to explicitly take care of the columns otherwise it'd cause
    anomaly(changing other items) in the matrix.
*/

public class Set_Matrix_Zeroes {
   public void setZeroes(int[][] matrix) {
      boolean colChange = false;
      int rows = matrix.length, cols = matrix[0].length;

      for (int r = 0; r < rows; r++) {
         if (matrix[r][0] == 0)
            colChange = true;
         for (int c = 1; c < cols; c++) {
            if (matrix[r][c] == 0)
               matrix[0][c] = matrix[r][0] = 0;
         }
      }

      for (int r = rows - 1; r >= 0; r--) {
         for (int c = cols - 1; c >= 1; c--)
            if (matrix[r][0] == 0 || matrix[0][c] == 0)
               matrix[r][c] = 0;

         if (colChange)
            matrix[r][0] = 0;
      }
   }
}