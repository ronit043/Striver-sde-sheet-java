package Day10;

/*      TC: O(9 ^ (n ^ 2)), SC: O(1)
Instead of trying all digits in the empty cell, we will try and find a solution using only those digits which
don't violate any of our conditions when placed in the cell [1 - 9].

Thus, before assigning a number to an empty cell, check if it satisfies all the rules. If yes then assign
this number to the cell and then recursively check if it leads to a successful filing of all the empty cells,
otherwise we backtrack, i.e. recreate original board matrix by removing assigned number. Base cases:

1. If row == 9, we return true as we successfully covered all rows from [0, 9).
2. If col == 9, we move to the next row.
3. If any cell has '.' i.e. empty, so we move to the next column.

Validating board

1. We set regionRow which is the region start row = 3 * (row / 3), and regionCol to 3 * (col / 3)
which is the region start column.

2. We loop from 0 to 8 and check the values – board[i][col](1st check) and board[row][i](2nd check),
whether the number is matching. For the 3rd check – the expression (regionRow + i / 3) = the row
numbers of that 3×3 sub-matrix and the expression (regionCol + i % 3) simplifies to the column numbers.
 */
class Sudoku_solver {
   public void solveSudoku(char[][] board) {
      dfs(board, 0, 0);
   }

   boolean dfs(char[][] board, int row, int col) {
      if (row == 9) return true;
      if (col == 9) return dfs(board, row + 1, 0);
      if (board[row][col] != '.') return dfs(board, row, col + 1);

      for (char num = '1'; num <= '9'; num++) { // Trial. Try 1 through 9
         if (isValid(board, row, col, num)) {
            board[row][col] = num; // Put num for this cell
            if (dfs(board, row, col + 1)) return true; // If it's the solution return true
            board[row][col] = '.'; // Otherwise go back
         }
      }
      return false;
   }

   boolean isValid(char[][] board, int row, int col, char num) {
      int regionRow = 3 * (row / 3), regionCol = 3 * (col / 3);  //region start row, col

      for (int i = 0; i < 9; i++) {
         if (board[i][col] == num || board[row][i] == num || // check row and column
         board[regionRow + i / 3][regionCol + i % 3] == num) return false; //check 3*3 block
      }

      return true;
   }
}