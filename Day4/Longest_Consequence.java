package Day4;

import java.util.*;

public class Longest_Consequence {
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