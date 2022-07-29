package Day12;
import java.util.*;

/*       TC: O(n * k * log(k)); N: average #items in every array, K: #arrays
         SC: O(n * k)
Use min-heap. As we know, the root of the min-heap is always the min item in the heap. Thus, insert the first
items of all the ‘K’ arrays into the heap, and then removing the min item and adding it to the output list
will give us the required result.

We create a Triplet class which stores values, array index in the 2d-array and the index of item in the
current row itself.

Create a min-heap of size K and insert the first item of all the arrays, along with its indices, as Triplet
object into the heap. The heap is ordered by the item of the list. While the heap isn't empty

1. Remove the minimum item from the heap, and add it to the list
2. If the next item of the extracted item exists, add it to the heap. If the array doesn’t have any more
   items i.e. if the index of the above-removed component is equal to ‘LENGTH-1’ of the array from which the
   item is extracted, then we're done with the array.

Return the result list.
 */
public class Merge_k_sorted_arrays {
   List<Integer> mergeKSortedArrays(List<List<Integer>> arr, int k) {
      List<Integer> res = new ArrayList<>();
      // Create a min heap with k heap nodes.
      Queue<Triplet> pq = new PriorityQueue<>((a, b) -> a.value - b.value);

      // Initially add only first item of every array
      for (int i = 0; i < arr.size(); i++)
         pq.add(new Triplet(arr.get(i).get(0), i, 0));

      while (!pq.isEmpty()) {
         Triplet curr = pq.poll();
         res.add(curr.value);
         // i: the array number and j: index of the removed item in the ith array.
         int i = curr.array_idx, j = curr.item_idx;

         if (j < (arr.get(i).size() - 1))
            pq.add(new Triplet(arr.get(i).get(j + 1), i, j + 1));
      }

      return res;
   }
}

class Triplet {
   int value, array_idx, item_idx;
   Triplet(int _value, int _array_idx, int _item_idx) {
      value = _value;
      array_idx = _array_idx;
      item_idx = _item_idx;
   }
}