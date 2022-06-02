package Day4;
/*
    TC: O(n), SC : O(1) 
    
    We use a HashSet which can check the presence of an item in O(1).
    Store all the items in HashSet. For every item check, if it is a starting item of sequence
    or not. by simply checking if ‘i’ - 1 is present in a HashSet or not. If it is present, so
    it means ‘i’ can’t be the first item of the sequence.
    
    If the item is the first item then count the total number of items that can occur in sequence by
    incrementing the item by 1 in each iteration of the while loop. Update count of the longest consecutive
    sequence.
 */
import java.util.*;

public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> hs = new HashSet<>();

        for (int i : nums) hs.add(i);
        for (int i : nums) {
            int cnt = 1;
            if (!hs.contains(i - 1)) {
                int j = i;
                while (hs.contains(j + 1)) { cnt++; j++; }
            }
            max = Math.max(max, cnt);
        }

        return max;
    }
}