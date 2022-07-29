package Day12;
import java.util.*;

/*    TC: O(K log(D)); D = #distinct(unique) items in the input array
      There are D elements in the heap, and we call poll() K times
      SC: O(D);

1. Use a frequency map.
2. Create a max heap, sort based on frequency at insertion.
3. Add all the distinct items to the heap(use keySet to get all items from hm keys), poll top k
   frequent items off the heap.
4. Use streams and map api to get primitive int values from Integer object and return as array.
 */
class Top_K_frequent_elements {
   public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> hm = new HashMap<>();
      for (int i : nums) hm.put(i, hm.getOrDefault(i, 0) + 1);
      Queue<Integer> pq = new PriorityQueue<>((a, b) -> (hm.get(a) - hm.get(b)));

      for (int i : hm.keySet()) {
         pq.add(i);
         if (pq.size() > k) pq.poll();
      }

      return pq.stream().mapToInt(i -> i).toArray();
   }
}