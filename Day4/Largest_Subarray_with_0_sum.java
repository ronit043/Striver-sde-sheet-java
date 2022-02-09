package Day4;

import java.util.HashMap;
import java.util.Map;

public class Largest_Subarray_with_0_sum {
    int maxLen(int arr[], int n) {
        int ans = 0, sum = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum == 0) ans = i + 1; 
            if (hm.containsKey(sum)) ans = Math.max(i - hm.get(sum), ans);
            else hm.put(sum, i);
        }
        return ans;
    }
}