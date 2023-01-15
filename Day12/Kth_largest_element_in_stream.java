package Day12;
import java.util.*;
/*    TC: O(N + K * logN), SC: O(N)
Use a min-heap. Since the top item of the min-heap is the smallest item of the heap, we continue to add items
to the heap, until it's size <= k, otherwise we remove the top items from the heap. Because by keeping size
of the heap as k, we remove (n - k) smaller items off the heap which won't be contributing to the kth-largest
item. After finishing iteration just return the top item of the PriorityQueue.
 */

class Kth_largest_element_in_stream {
   public int findKthLargest(int[] nums, int k) {
      Queue<Integer> pq = new PriorityQueue<>();

      for (int num : nums) {
         pq.add(num);
         if (pq.size() > k) pq.poll();
      }
      return pq.peek();
   }
}