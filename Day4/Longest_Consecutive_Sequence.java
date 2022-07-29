package Day4;
/*      TC: O(n), SC : O(1) 
    
We use a HashSet which can check the presence of an item in O(1). Store all the items in Set. For every
item check, if it is a starting item of sequence or not. by simply checking if ‘i’ - 1 is present in a Set.
If it is present, it means ‘i’ can’t be the first item of the consecutive sequence.

If it is, then count the total number of items that can occur in sequence by incrementing the item by 1
in each iteration of the while loop. Update length of the longest consecutive sequence.
 */

import java.util.*;

public class Longest_Consecutive_Sequence {
   public int longestConsecutive(int[] nums) {
      int len = 0;
      Set<Integer> hs = new HashSet<>();

      for (int i : nums) hs.add(i);
      for (int i : nums) {
         if (hs.contains(i - 1)) continue;
         int cnt = 1;
         while (hs.contains(i + cnt)) cnt++;
         len = Math.max(len, cnt);
      }

      return len;
   }
}