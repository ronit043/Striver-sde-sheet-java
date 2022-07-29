package Day4;
/*
    TC: O(n), SC: O(k), where k is the number of unique characters

    Take two indexes left and right(l & r) both at 0th index and a set which stores characters between l & r
    While the right index is within limits. While the character is present in the set. Add the character to
    the window. Take the max of maxLen & length of the substring "right - left". Return the max length.
 */

import java.util.HashSet;
import java.util.Set;

public class Longest_Sub_string_without_repeat {
   public int lengthOfLongestSubstring(String s) {
      int l = 0, r = 0, maxLen = 0;
      Set<Character> window = new HashSet<>();

      while (r < s.length()) {
         while (window.contains(s.charAt(r))) window.remove(s.charAt(l++));
         window.add(s.charAt(r++));
         maxLen = Math.max(maxLen, r - l);
      }

      return maxLen;
   }
}