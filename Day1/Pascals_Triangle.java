package Day1;

/*
    TC : O(n ^ 2), SC : O(n ^ 2)

Solution

We observe for every row, the first and last(equal to row number) column will be 1, so add 1
For every other column the value is sum of value in (previous row, same column) and
sum of value in (previous row, previous column).
*/

import java.util.*;

public class Pascals_Triangle {
   public List<List<Integer>> generate(int rows) {
      List<List<Integer>> ans = new ArrayList<>();

      for (int row = 0; row < rows; row++) {
         List<Integer> res = new ArrayList<>();
         for (int col = 0; col <= row; col++) {
            if (col == 0 || col == row)
               res.add(1);
            else
               res.add(
                       ans.get(row - 1).get(col - 1) + ans.get(row - 1).get(col)
               );
         }
         ans.add(res);
      }

      return ans;
   }
}