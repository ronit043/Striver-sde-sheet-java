package Day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
	TC : O(n log(n)) + O(n); SC : O(n)

Solution

The idea is to sort the intervals by their starting points. Then, we take the first interval and
compare its end with the next intervals start. As long as they overlap, we update the end to be
the max end of the overlapping intervals. On finding a non overlapping interval, we can add the
previous "extended" interval and start over.

 */
public class Merge_Overlapping_Subintervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0], end = intervals[0][1];

        for (var interval : intervals) {
            if (interval[0] <= end)
                end = Math.max(end, interval[1]);
            else {
                ans.add(new int[] {start, end});
                start = interval[0];
                end = interval[1];
            }
        }

        ans.add(new int[] {start, end});
        return ans.toArray(new int[0][0]);
    }
}
