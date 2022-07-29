package Day4;
/*
    TC: O(n), SC : O(n)

Use a HashMap to store the prefix XOR of the sub-array. We’ll iterate over the given array and calculate the
number of sub-arrays ending at a particular index and having a XOR sum of ‘B’.

Create a map prefXor storing count of sub-arrays having a particular XOR value. Initialise ans & curr_xor to 0.
In the iteration update the “curr_xor” i.e. curr_xor ^= i. Store required value of the prefix Xor to make the
curr_xor of the sub-array ending at the current index equal to B i.e. req = B ^ curr_xor. If the required item
is found (in the map) add the count of prefix arrays with required curr_xor i.e. ans += prefXor[req].
Update the “prefXor” HashMap with the “curr_xor” i.e. prefXor[curr_xor] = prefXor[curr_xor] + 1.
If curr_xor equals B, then increment ans by 1.
 */

import java.util.HashMap;
import java.util.Map;

public class Count_sub_arrays_with_given_xor {
   public int subArrayXor(int[] A, int B) {
      Map<Integer, Integer> prefXor = new HashMap<>();
      int ans = 0, curr_xor = 0;

      for (int i : A) {
         curr_xor ^= i;
         if (curr_xor == B) ans++;
         int req = curr_xor ^ B;
         if (prefXor.get(req) != null) ans += prefXor.get(req);
         prefXor.put(curr_xor, prefXor.getOrDefault(curr_xor, 0) + 1);
      }

      return ans;
   }
}