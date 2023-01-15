package Day04;
/*
    TC: O(n), SC : O(n)

Use a HashMap to store the prefix XOR of the sub-array. We’ll iterate over the given array and calculate the
number of sub-arrays ending at a particular index and having a XOR sum of ‘B’.

Create a map hm storing count of sub-arrays having a particular XOR value. Initialise count & xor to 0.
In the iteration update the “xor” i.e. xor ^= i. Store required value of the prefix Xor to make the
xor of the sub-array ending at the current index equal to B i.e. req = B ^ xor. If the required item
is found (in the map) add the count of prefix arrays with required xor i.e. count += hm[req].
Update the “hm” HashMap with the “xor” i.e. hm[xor] = hm[xor] + 1.
If xor equals B, then increment count by 1.
 */

import java.util.HashMap;
import java.util.Map;

class Count_sub_arrays_with_given_xor {
   public int subArrayXor(int[] A, int B) {
      Map<Integer, Integer> hm = new HashMap<>();
      int count = 0, xor = 0;

      for (int i : A) {
         xor ^= i;
         if (xor == B) count++;
         if (hm.containsKey(xor ^ B)) count += hm.get(xor ^ B);
         hm.put(xor, hm.getOrDefault(xor, 0) + 1);
      }

      return count;
   }
}