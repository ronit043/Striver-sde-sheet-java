package Day1;

/*
    TC : O(n ^ 2)
    SC : O(n ^ 2)
*/

/*
Solution

We observe for every row, the first column and last column will be 1, so add 1
For every other column the value is sum of value1(previous row, same column) and
sum of value2(previous row, previous column).
*/

import java.util.*;

public class Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) row.add(1);
                else
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            res.add(row);
        }

        return res;
    }
}