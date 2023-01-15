package Day12;
import java.awt.Point;
import java.util.*;

/*       TC: O(N * K * log(K)); N: average #items in every array, K: #arrays
         SC: O(N * K)
Use min-heap. As we know, the root of the min-heap is always the min item in the heap. Thus, insert the
first items of all the ‘K’ arrays into the heap, and then removing the min item and adding it to the
output list will give us the required result.
Using Point class which holds array index as x and the index of item in the current row as y.

In the min-heap, insert the row number and the 0 as Point object into the heap. The heap is ordered
by the item of the list. While the heap isn't empty:

1. Remove the minimum item from the heap, and add it to the list.
2. If there are more item in the row i.e. by checking the size, add it to the heap and increase the index.

Return the result list.
 */
class Merge_k_sorted_arrays {
   public List<Integer> solve(List<List<Integer>> A) {
      Queue<Point> pq = new PriorityQueue<>((a, b) -> A.get(a.x).get(a.y) - A.get(b.x).get(b.y));
      List<Integer> ans = new ArrayList<>();
      int k = A.size();
      for (int i = 0; i < k; i++) pq.add(new Point(i, 0));

      while (!pq.isEmpty()) {
         Point curr = pq.poll();
         ans.add(A.get(curr.x).get(curr.y));
         if (curr.y < A.get(curr.x).size() - 1) {
            curr.y++;
            pq.add(curr);
         }
      }

      return ans;
   }
}