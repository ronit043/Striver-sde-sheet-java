package Day08;

import java.util.Arrays;

/*      TC: O(nlog(n)), SC: O(1)
We need to sort both arrays. When the events will be sorted, it will be easy to track the count of trains that
have arrived but not departed yet. Max platforms needed can be found comparing, arrival and departure times.

If(arr[i] <= dep[j]) means if arrival time <= departure time then, we need one more platform. So increment
platform as well as increment i.

If(arr[i] > dep[j]) means arrival time > departure time then, we have an extra platform which we can reduce.
So decrement count but increment j.

Take the maximum number of platforms in maxPlatforms variable.
 */
public class Minimum_Platforms {
   public int findPlatform(int[] arr, int[] dep, int n) {
      int maxPlatforms = 1, arrHour = 1, depHour = 0, platform = 1;
      Arrays.sort(arr);
      Arrays.sort(dep);

      while (arrHour < n && depHour < n) {
         if (arr[arrHour] <= dep[depHour]) {
            platform++;
            arrHour++;
         } else {
            platform--;
            depHour++;
         }
         maxPlatforms = Math.max(maxPlatforms, platform);
      }

      return maxPlatforms;
   }
}