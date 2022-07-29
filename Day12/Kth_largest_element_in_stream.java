package Day12;
import java.util.*;
/*    TC: O(N + K * logN), SC: O(N)
Use a max-heap. Since the top item of the max-heap is the largest item of the heap, we continue to add items
to the heap, until it's size <= k, otherwise we remove the top items from the heap. The top item of priority
queue will be Kth Largest item.
 */

public class Kth_largest_element_in_stream {
   public int findKthLargest(int[] nums, int k) {
      Queue<Integer> pq = new PriorityQueue<>();

      for (int num : nums) {
         pq.add(num);
         if (pq.size() > k) pq.poll();
      }
      return pq.peek();
   }
}