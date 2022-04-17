package Day1;

/*
    TC : O(2 * (m * n))
    SC : O(1)
*/

/*
Solution:

We first traverse from top to bottom and check
    If the first column of any row is 0 or not, if so set the colChange value to true.

    We then move from index 1 of every row and check if any element is 0, if so set
    the topmost and leftmost value to 0, we do this to keep a track of which items to change
    when we come back later.

In the 2nd traversal
    If the leftmost or topmost value is 0 then set that item to 0.
    Before moving to the next row, change the first column value to 0, if colChange is true
*/

public class Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        boolean colChange = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) colChange = true;
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) matrix[0][j] = matrix[i][0] = 0;
            }
        }
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
            if (colChange) matrix[i][0] = 0;
        }
    }
}