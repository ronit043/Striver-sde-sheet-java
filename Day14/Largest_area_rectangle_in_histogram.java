package Day14;
import java.util.ArrayDeque;
import java.util.Deque;
/*          TC: O(n), SC: O(n)

We need to find index of left smaller and right smaller for all histograms. We traverse all histograms from
left to right, maintaining a stack of histograms. Let us call these indexes 'LEFT_INDEX' and ‘RIGHT_INDEX’.

Every histogram is pushed to stack once. A bar is popped from the stack when it's height < bar @ top of
stack(to find right smaller). When a bar is popped, we calculate the area of the popped bar. How do we get
the left and right indexes of the popped bar –> the current index tells us the ‘RIGHT_INDEX’ and index at
stack top is the 'LEFT_INDEX'.

If the stack is empty, then 'i' is the width else ‘RIGHT_INDEX’ - ‘LEFT_INDEX’ - 1. The height =
heights[popped stack item]. We then calculate the area and store max of all areas in maxArea.
 */
class Largest_area_rectangle_in_histogram {
   int largestRectangleArea(int[] heights) {
      int n = heights.length, maxArea = 0;
      Deque<Integer> stq = new ArrayDeque<>();

      for (int i = 0; i <= n; i++) {
         int currHeight = (i == n) ? 0 : heights[i];
         while (!stq.isEmpty() && currHeight < heights[stq.peek()]) {
            int building_idx = stq.pop(),
                width = stq.isEmpty() ? i : i - stq.peek() - 1,
                area = heights[building_idx] * width;

            maxArea = Math.max(area, maxArea);
         }
         stq.push(i);
      }

      return maxArea;
   }
}