package Day22;

import java.util.PriorityQueue;
import java.util.Queue;

public class Kth_largest_element_in_stream {
    Queue<Integer> pq;
    int k;
    public Kth_largest_element_in_stream(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int n : nums) add(n);
    }

    public int add(int val) {
        if (pq.size() < k) pq.add(val);
        else if (val > pq.peek()) {
            pq.poll();
            pq.add(val);
        }

        return pq.peek();
    }
}