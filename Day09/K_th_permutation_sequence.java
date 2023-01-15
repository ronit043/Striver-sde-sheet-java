package Day09;
import java.util.ArrayList;
import java.util.List;

/*      TC: O(n ^ 2), SC: O(n)
The first position of an n length sequence is occupied by each of the numbers from 1 to n exactly (n - 1)!
times in the ascending order. So the first position of the kth sequence will be occupied by the number
present at index = k / (n - 1)!. The problem reduces to finding the (k % (n - 1)!)th permutation sequence
of the remaining n - 1 numbers.
*/
class K_th_permutation_sequence {
   public String getPermutation(int n, int k) {
      List<Integer> list = new ArrayList<>();
      int fact = 1;
      StringBuilder sb = new StringBuilder();

      for (int i = 1; i <= n; i++) list.add(i);
      for (int i = 2; i <= n; i++) fact *= i; // factorial

      for (k--; n > 0; n--) {
         fact /= n;
         sb.append(list.remove(k / fact));
         k %= fact;
      }

      return sb.toString();
   }
}