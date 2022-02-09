package Day14;

import java.util.ArrayDeque;
import java.util.Deque;

public class Largest_area_rectangle_in_histogram {
    public int largestRectangleArea(int[] heights) {
        int maxA = 0, n = heights.length;
        Deque<Integer> stq = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            while (!stq.isEmpty() && (i == n || heights[stq.peek()] >= heights[i])) {
                int h = heights[stq.pop()];
                int rightB = i - 1, leftB = stq.isEmpty() ? 0 : stq.peek() + 1;
                int w = rightB - leftB + 1;
                maxA = Math.max(maxA, (h * w));
            }
            stq.push(i);
        }
        return maxA;
    }
}