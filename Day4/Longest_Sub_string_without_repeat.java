package Day4;

import java.util.HashSet;
import java.util.Set;

public class Longest_Sub_string_without_repeat {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, max = 0;
        Set<Character> hs = new HashSet<>();
        while(r < s.length()) {
            if(!hs.contains(s.charAt(r))) {
                hs.add(s.charAt(r++));
                max = Math.max(max, hs.size());
            }
            else hs.remove(s.charAt(l++));
        }
        return max;
    }
}