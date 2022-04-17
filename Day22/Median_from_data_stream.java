package Day22;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Median_from_data_stream {
    private Queue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private Queue<Integer> large = new PriorityQueue<>();
    private boolean even = true;

    public double findMedian() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }

    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }
}