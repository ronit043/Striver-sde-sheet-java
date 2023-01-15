package Day08;

import java.util.Arrays;

/*      TC : O(n log n) + O(n ^ 2), SC : O(n)

The strategy to maximize profit should be to pick up jobs that give higher profits. Hence, we should sort
the jobs in descending order of profit. Make a boolean array of size n. Each array index is false by
default as no jobs have been performed yet. For each job check if it can be performed on its last day.
If it's possible, then mark that index with true, increment job count & add the profit to our answer.
 */
public class Job_Sequencing {
   int[] JobScheduling(Job[] arr, int n) {
      int profit = 0, jobs = 0;
      Arrays.sort(arr, (p1, p2) -> p2.profit - p1.profit);
      boolean[] avail = new boolean[n];

      for (int i = 0; i < n; i++) {
         for (int j = Math.min(n - 1, arr[i].deadline - 1); j >= 0; j--) {
            if (!avail[j]) {
               avail[j] = true;
               jobs++;
               profit += arr[i].profit;
               break;
            }
         }
      }

      return new int[]{jobs, profit};
   }
}

class Job {
   int id, deadline, profit;

   Job(int _id, int _deadline, int _profit) {
      id = _id;
      deadline = _deadline;
      profit = _profit;
   }
}