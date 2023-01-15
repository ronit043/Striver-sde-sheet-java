package Day08;

import java.util.Arrays;

/*   TC : O(nlog(n)), SC : O(n)

Create a Meeting class, with start & end attributes. Set prevEndTime and meetings to 0. Now create a
meeting array of size n, store the starting and ending times of meetings and sort the array on ending time
basis.

Now meetings will conduct only when there is no overlap b/w the intervals. If the start time of a meeting
exceeds the end time of previous meeting then a meeting can conduct with prev end time = current end time.
 */
public class N_meetings_in_a_room {
   public static int maxMeetings(int[] start, int[] end, int n) {
      int prevEndTime = 0, meetings = 0;
      Meeting[] arr = new Meeting[n];
      for (int i = 0; i < n; i++) arr[i] = new Meeting(start[i], end[i]);
      Arrays.sort(arr, (x, y) -> x.end - y.end);

      for (int i = 0; i < n; i++) {
         if (arr[i].start > prevEndTime) {
            meetings++;
            prevEndTime = arr[i].end;
         }
      }

      return meetings;
   }
}

class Meeting {
   int start, end;

   Meeting(int _start, int _end) {
      start = _start;
      end = _end;
   }
}