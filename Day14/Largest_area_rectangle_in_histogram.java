package Day14;
import java.util.ArrayDeque;
import java.util.Deque;
/*          TC: O(n), SC: O(n)

We need to know the index of the first smaller (smaller than ‘X’) bar on the left of ‘X’ and the index of
the first smaller bar on the right of ‘X’. We traverse all histograms from left to right, maintaining a stack
of histograms. Let us call these indexes ‘LEFT_INDEX' and ‘RIGHT_INDEX’ respectively.

We traverse all histograms from left to right, maintaining a stack of histograms. Every histogram is pushed
to stack once. A bar is popped from the stack when it's height < bar @ top of stack. When a bar is popped,
we calculate the area of the popped bar. How do we get the left and right indexes of the popped bar –>
the current index tells us the ‘RIGHT_INDEX’ and the index at stack top is the ‘LEFT_INDEX'.

If the stack is empty, then 'i' is the width else ‘RIGHT_INDEX’ - ‘LEFT_INDEX’ - 1. The height =
heights[popped stack item]. We then calculate the area and store max of all areas in maxArea.
 */
public class Largest_area_rectangle_in_histogram {
   int largestRectangleArea(int[] heights) {
      int n = heights.length, maxArea = 0;
      Deque<Integer> stq = new ArrayDeque<>();

      for (int i = 0; i <= n; i++) {
         int currHeight = (i == n) ? 0 : heights[i];
         while (!stq.isEmpty() && heights[stq.peek()] > currHeight) {
            int height_idx = stq.pop(),
                width = stq.isEmpty() ? i : i - stq.peek() - 1,
                area = heights[height_idx] * width;

            maxArea = Math.max(area, maxArea);
         }
         stq.push(i);
      }

      return maxArea;
   }
}