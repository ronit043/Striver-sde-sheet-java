package Day4;

import java.util.HashMap;
import java.util.Map;

public class Count_subarrays_with_given_xor {
    public int subarrayXor(int[] A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, xor = 0;

        for (int j : A) {
            xor ^= j;
            if (map.get(xor ^ B) != null) res += map.get(xor ^ B);
            if (xor == B) res++;
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return res;
    }
}