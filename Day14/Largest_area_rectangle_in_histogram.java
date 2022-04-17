package Day14;

import java.util.ArrayDeque;
import java.util.Deque;

public class Largest_area_rectangle_in_histogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, maxArea = 0;
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];
            // check if currHeight becomes greater than height[curr] element of stack. we do a push because it's an increasing sequence
            // otherwise we do pop and find area, so for that we write a while loop
            while (!st.isEmpty() && currHeight < heights[st.peek()]) {
                int curr = st.pop(); // current element on which we are working
                // now we need width & area
                int width = st.isEmpty() ? i : i - st.peek() - 1; // width differ, if stack is empty or not empty after we pop the element
                int area = heights[curr] * width; // current height * width
                maxArea = Math.max(area, maxArea);
            }
            // if it doesn't enter in while loop, it means it's an increasing sequence & we need to push index
            st.push(i);
        }

        return maxArea;
    }
}