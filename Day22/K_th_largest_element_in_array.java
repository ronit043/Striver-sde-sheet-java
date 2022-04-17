package Day22;

import java.util.PriorityQueue;
import java.util.Queue;

public class K_th_largest_element_in_array {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++) {
            if(i < k) pq.add(nums[i]);
            else {
                if (pq.peek() < nums[i]) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }

        return pq.peek();
    }
}