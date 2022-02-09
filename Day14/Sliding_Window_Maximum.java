package Day14;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>(); // stores indices
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // remove indices from deque that are out of bound
            if (!q.isEmpty() && q.peekFirst() == i - k) q.pollFirst();
            // remove indices whose corresponding values are less than nums[i]
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) q.pollLast();
            q.addLast(i);
            // if window has k elements add to results (first k-1 windows have < k elements
            // because we start from empty window and add 1 element each iteration)
            if (i >= k - 1) res.add(nums[q.peekFirst()]);
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}