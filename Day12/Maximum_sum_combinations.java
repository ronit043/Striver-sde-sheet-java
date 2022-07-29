package Day12;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
/*
Sort both arrays A and B. Create a max heap of size k to store the sum combinations along with the indices
of items from both arrays A and B which make the sum. Heap is ordered by the sum of both items.

Initialize the heap with the last index of second array and with maximum possible sum combination i.e
(A[N – 1] + B[N – 1] where N: array size). The entity inside heap will be (A[N - 1] + B[N – 1], N – 1)

Pop the heap to get the current largest sum and along with the indices of the element that make up the sum.
 */
public class Maximum_sum_combinations {
   public int[] solve(int[] A, int[] B, int k) {
      Arrays.sort(A);
      Arrays.sort(B);
      int heap_size = 1, ans[] = new int[k];
      Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

      for (int j = A.length - 1; j >= 0 && heap_size <= k; j--) {
         pq.add(new int[]{B.length - 1, A[j] + B[B.length - 1]});
         heap_size++;
      }
      for (int j = 0; j < k && !pq.isEmpty(); j++) {
         int[] te = pq.poll();
         ans[j] = te[1]; // ans[j] will store the max possible sum
         // te[0], will store the index where max possible sum was obtained
         // If the index is more than -1, we add its previous index, and update the sum
         // so that it excludes the value @ B[te[0]] and add B[te[0] - 1] because it is the overlap
         if (te[0] - 1 >= 0)
            pq.add(new int[]{te[0] - 1, te[1] - B[te[0]] + B[te[0] - 1]});
      }

      return ans;
   }
}