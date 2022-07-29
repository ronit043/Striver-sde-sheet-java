package Day8;

import java.util.Arrays;

/*
        TC : O(nlog(n)), SC : O(n)
Explanation similar to no. of meeting rooms
 */
public class Activity_Selection {
   static int activitySelection(int[] start, int[] end, int n) {
      int prevEndTime = 0, activity = 0;
      Activity[] arr = new Activity[n];
      for (int i = 0; i < n; i++) arr[i] = new Activity(start[i], end[i]);
      Arrays.sort(arr, (a, b) -> a.end - b.end);

      for (int i = 0; i < n; i++) {
         if (arr[i].start > prevEndTime) {
            activity++;
            prevEndTime = arr[i].end;
         }
      }

      return activity;
   }
}

class Activity {
   int start, end;

   Activity(int _start, int _end) {
      start = _start;
      end = _end;
   }
}