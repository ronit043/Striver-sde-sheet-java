package Day11;
import java.util.Arrays;

/*      TC: O(n * log(n)), SC: O(1)
We need to place all cows in the N stalls such that the minimum distance between any two of them is as
large as possible. Let mid be the minimum distance. Check in the sorted array, how many stalls are available
so that the minimum distance between them is this mid.

If we get a possible position, then store it and check for more separation setting low as mid + 1,
otherwise, we don't store the result and decrease the separation by making high as mid - 1.

We need to define a check() function that checks if a distance x is possible between each of the cows. We can
use a greedy approach here by placing cows at the leftmost possible stalls such that they are at least x
distance away from the last-placed cow.
 */
class Aggressive_Cows {
   public int maximiseDistance(int cows, int[] stalls) {
      Arrays.sort(stalls);
      // l is the least possible distance and r is the max possible distance
      int l = 1, r = stalls[stalls.length - 1] - stalls[0], ans = -1;

      while (l <= r) {
         int mid = l + (r - l) / 2;
         if (check(stalls, mid, cows)) {
            ans = mid;
            l = mid + 1;
         } else r = mid - 1;
      }

      return ans;
   }

   boolean check(int[] stalls, int minDist, int cows) {
      // The first stall is taken by the first cow. Start from the second stall with index 1.
      int last_taken_stall = stalls[0], cows_placed = 1;

      for (int stall_idx = 1; stall_idx < stalls.length; stall_idx++) {
         // Calculate the distance between the current stall and the last stall, where the cow was placed
         // Place current cow, in case the distance is at least the given minimal distance
         if (stalls[stall_idx] - last_taken_stall >= minDist) {
            cows_placed++;
            last_taken_stall = stalls[stall_idx];
         }
      }

      return cows_placed >= cows;
   }
}