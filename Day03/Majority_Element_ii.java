package Day03;
import java.util.*;

/*    TC : O(n), SC : O(1)
The idea is to use a modification of Moore's voting algorithm to find candidate elements(at most 2) that
may occur more than N/3 times in the given array. We will use the fact that if we remove 3 distinct elements
from the array, the elements which occurred more than N / 3 times do not change.

1. Iterate through the array
    . If the current item(i) equals either of the candidates, then increase count of that item
    . If one of their votes = 0, set that candidate's vote to 1 and current item to the majority
    . Otherwise, decrease vote of both candidates. Doing so we'll remove 3 distinct elements from the array
    which won't hamper the answer.

2. Reset both votes to 0, iterate through the array and check whether the votes of the candidates
exceed (N / 3), if so add the items to the list and return.
 */

class Majority_Element_ii {
   public List<Integer> majorityElement(int[] nums) {
      int maj1 = -1, maj2 = -1, vote1 = 0, vote2 = 0, thresh = nums.length / 3;
      List<Integer> al = new ArrayList<>();

      for (int i : nums) {
         if (i == maj1) vote1++;
         else if (i == maj2) vote2++;
         else if (vote1 == 0) {
            vote1 = 1;
            maj1 = i;
         } else if (vote2 == 0) {
            vote2 = 1;
            maj2 = i;
         } else {
            vote1--;
            vote2--;
         }
      }

      vote1 = 0;
      vote2 = 0;
      for (int i : nums) {
         if (i == maj1) vote1++;
         else if (i == maj2) vote2++;
      }

      if (vote1 > thresh) al.add(maj1);
      if (vote2 > thresh) al.add(maj2);

      return al;
   }
}