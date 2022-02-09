package Day13;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Next_greater_element {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Deque<Integer> adq = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums2) {            
            while(!adq.isEmpty() && num > adq.peek()) map.put(adq.pop(), num);
            adq.push(num);            
        }
        
        int i = 0;        
        for(int num : nums1) result[i++] = map.getOrDefault(num, -1);
        return result;
    }
}
