package Day10;
import java.util.ArrayList;
import java.util.List;

/*          TC : O(N * N!), SC : O(N)
We can find all the permutations by Backtracking.

1. Fix a character then swap all the rest of the remaining character with a fixed character.
2. Then find all permutations for all remaining characters by the recursive call.
3. The base case for the recursion will be when there is only one character left unprocessed.
 */
class Permutations_String {
   void dfs(List<String> res, StringBuilder s, int l, int r) {
      if (l == r) { res.add(s.toString()); return; }
      for (int i = l; i <= r; i++) {
         swap(s, l, i);
         dfs(res, s, l + 1, r);
         swap(s, l, i);
      }
   }

   void swap(StringBuilder s, int i, int j) {
      char temp = s.charAt(i);
      s.setCharAt(i, s.charAt(j));
      s.setCharAt(j, temp);
   }

   public List<String> findPermutations(String s) {
      List<String> res = new ArrayList<>();
      dfs(res, new StringBuilder(s), 0, s.length() - 1);
      return res;
   }
}