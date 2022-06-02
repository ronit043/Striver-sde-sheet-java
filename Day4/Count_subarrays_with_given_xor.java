package Day4;
/*
    TC: O(n), SC : O(n)

Use a HashMap to store the prefix XOR of the sub-array. We’ll iterate over the given array and calculate the
number of sub-arrays ending at a particular index and having a XOR sum of ‘B’.

Create a map prefXor storing count of sub-arrays having a particular XOR value. Initialise ans & xor to 0.
In the iteration update the “xor” i.e. xor ^= i. Store required value of the prefix Xor to make the xor of the
sub-array ending at the current index equal to B i.e. req = B ^ xor. If the required item is found (in the map)
add the count of prefix arrays with required xor i.e. ans += prefXor[req]. Update the “prefXor” HashMap with the “xor”
i.e. prefXor[xor] = prefXor[xor] + 1. If xor equals B, then increment ans by 1.
 */
import java.util.HashMap;
import java.util.Map;

public class Count_subarrays_with_given_xor {
    public int subarrayXor(int[] A, int B) {
        Map<Integer, Integer> prefXor = new HashMap<>();
        int ans = 0, xor = 0;

        for (int i : A) {
            xor ^= i;
            int req = xor ^ B;
            if (prefXor.get(req) != null) ans += prefXor.get(req);
            prefXor.put(xor, prefXor.getOrDefault(xor, 0) + 1);
            if (xor == B) ans++;
        }

        return ans;
    }
}