package Day12;
import java.util.PriorityQueue;
import java.util.Queue;

/*    TC: O(log(N)), SC: O(N)
The idea is to divide numbers into 2 balanced halves, one half low stores low numbers, the other half high
stores high numbers. To access the median in O(1), we need a data structure that give us the maximum of low
half and the minimum of high half in O(1). That's where maxHeap and minHeap come into play.

We use maxHeap to store a half of low numbers, top of the maxHeap is the highest number among low numbers.
We use minHeap to store a half of high numbers, top of the minHeap is the lowest number among high numbers.

When adding a new number num into our Median finder:
Firstly, add num to the maxHeap, now maxHeap may contain the big element (which should belong to minHeap).
So we need to balance, by removing the highest element from maxHeap, and offer it to minHeap.
Now, the minHeap might hold more elements than maxHeap, in that case, we need to balance the size,
by removing the lowest element from minHeap and offer it back to maxHeap.

When doing findMedian():
If maxHeap.size > minHeap.size return top of the maxHeap, which is the highest number among low numbers.
Else if maxHeap.size == minHeap return the (maxHeap.top() + minHeap.top()) / 2.
 */
public class Median_from_data_stream {
   Queue<Integer> minHeap = new PriorityQueue<>(),
                  maxHeap = new PriorityQueue<>((a, b) -> b - a);

   public Median_from_data_stream() { }

   public void addNum(int num) {
      maxHeap.add(num);
      minHeap.add(maxHeap.poll());
      if (minHeap.size() > maxHeap.size()) maxHeap.add(minHeap.poll());
   }

   public double findMedian() {
      if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
      return (minHeap.peek() + maxHeap.peek()) / 2.0d;
   }
}