package Day14;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> adq = new ArrayDeque<>();
        List<Integer> al = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            // Making sure elements in the deque aren't smaller than the current element
            while(!adq.isEmpty() && nums[i] >= nums[adq.peekLast()]) adq.pollLast();

            adq.offerLast(i);

            // If any index goes out of bounds, then remove
            if(!adq.isEmpty() && adq.peekFirst() == i - k) adq.pollFirst();

            // Otherwise add
            if(i >= k - 1) al.add(nums[adq.peekFirst()]);
        }

        return al.stream().mapToInt(i -> i).toArray();
    }
}