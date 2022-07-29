package Day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
	TC : O(n log(n)) + O(n); SC : O(n)

The idea is to sort the intervals in the increasing order of starting points. Then, we take the current
interval and compare its start with the last intervals' end. If they overlap, we update the last ending time
to the max of end of the overlapping intervals. If the list is empty or if the intervals don't overlap, we add
the current interval to the list. At last return the list.
 */
public class Merge_Overlapping_Sub_Intervals {
   public int[][] merge(int[][] intervals) {
      List<int[]> ans = new ArrayList<>();
      Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

      for (var interval : intervals) {
         // Here ans.get(ans.size() - 1)[1] is the last interval end
         // interval[0] is current start, interval[1] is current end
         if (!ans.isEmpty() && interval[0] <= ans.get(ans.size() - 1)[1])
            ans.get(ans.size() - 1)[1] = Math.max(interval[1], ans.get(ans.size() - 1)[1]);
         else
            ans.add(interval);
      }

      return ans.toArray(new int[0][0]);
   }
}
