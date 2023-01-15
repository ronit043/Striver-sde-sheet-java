package Day10;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*    TC: O(n ^ 2), SC: O(n)
Optimisation of isSafe function. The idea is not to check every item in right and left diagonal, instead use
property of diagonals:

1. The sum of i and j is constant and unique for each right diagonal, where i is the row of item and j
is the column of item. 

2. The difference of i and j is constant and unique for each left diagonal, where i and j are row and column
of item respectively.
 */

class N_Queens {
   public List<List<String>> solveNQueens(int n) {
      char[][] board = new char[n][n];
      for (char[] cs : board) Arrays.fill(cs, '.');
      List<List<String>> al = new ArrayList<>();
      dfs(board, 0, al);
      return al;
   }

   public void dfs(char[][] board, int row, List<List<String>> res) {
      if (row == board.length) {
         List<String> list = new ArrayList<>();
         for (var chars : board) list.add(new String(chars));
         res.add(list);
         return;
      }

      for (int i = 0; i < board.length; i++) {
         if (isSafe(board, i, row)) {
            board[i][row] = 'Q';
            dfs(board, row + 1, res);
            board[i][row] = '.';
         }
      }
   }

   public boolean isSafe(char[][] board, int row, int col) {
      // check current row
      for (int i = 0; i < col; i++)
         if (board[row][i] == 'Q') return false;

      // check left upward diagonal
      for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
         if (board[i][j] == 'Q') return false;

      // check right upward diagonal
      for (int i = row, j = col; i < board.length && j >= 0; i++, j--)
         if (board[i][j] == 'Q') return false;

      return true;
   }
}