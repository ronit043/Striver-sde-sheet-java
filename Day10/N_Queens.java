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

public class N_Queens {
   public List<List<String>> solveNQueens(int n) {
      List<List<String>> al = new ArrayList<>();
      dfs(al, n, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], new ArrayList<>());
      return al;
   }

   void dfs(List<List<String>> al, int n, boolean[] cols, boolean[] diag45, boolean[] diag135, 
            List<String> temp) {
      if (temp.size() == n) {
         al.add(new ArrayList<>(temp));
         return;
      }
      int row = temp.size();
      for (int col = 0; col < n; col++) {
         if (cols[col] || diag45[row + col] || diag135[n - 1 - row + col]) continue;

         cols[col] = diag45[row + col] = diag135[n - 1 - row + col] = true;
         StringBuilder sb = new StringBuilder();
         sb.append(".".repeat(n));
         sb.setCharAt(col, 'Q');
         temp.add(sb.toString());

         dfs(al, n, cols, diag45, diag135, temp);

         cols[col] = diag45[row + col] = diag135[n - 1 - row + col] = false;
         temp.remove(temp.size() - 1);
      }
   }
}